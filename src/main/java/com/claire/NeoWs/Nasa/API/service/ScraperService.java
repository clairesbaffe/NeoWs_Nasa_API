package com.claire.NeoWs.Nasa.API.service;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.dto.NearEarthObjectDTO;
import com.claire.NeoWs.Nasa.API.entity.CloseApproach;
import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import com.claire.NeoWs.Nasa.API.exception.ScraperServiceException;
import com.claire.NeoWs.Nasa.API.mapping.CloseApproachMapping;
import com.claire.NeoWs.Nasa.API.mapping.NearEarthObjectMapping;
import com.claire.NeoWs.Nasa.API.repository.CloseApproachRepository;
import com.claire.NeoWs.Nasa.API.repository.NearEarthObjectRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScraperService {

    @Value("${NASA_API_KEY}")
    private String nasaApiKey;

    private final RestClient restClient;
    private final NearEarthObjectMapping nearEarthObjectMapping;
    private final CloseApproachMapping closeApproachMapping;
    private final NearEarthObjectRepository nearEarthObjectRepository;
    private final CloseApproachRepository closeApproachRepository;

    public void scrape(int page){
        try {
            String data = fetchData(page);
            parseData(data);
        } catch (Exception e) {
            throw new ScraperServiceException("Erreur lors du processus de scraping: " + e.getMessage());
        }
    }

    public String fetchData(int page){
        return restClient
                .get()
                .uri("https://api.nasa.gov/neo/rest/v1/neo/browse?page=" + page + "&api_key=" + nasaApiKey)
                .retrieve()
                .body(String.class);
    }

    public void parseData(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode root = objectMapper.readTree(jsonData);

            List<NearEarthObject> neoList = new ArrayList<>();
            JsonNode neos = root.path("near_earth_objects");
            List<CloseApproach> closeApproachesList = new ArrayList<>();

            for (JsonNode node : neos) {
                int neoReferenceId = node.path("neo_reference_id").asInt();
                String name = node.path("name").asText();
                String nameLimited = node.path("name_limited").asText();
                double absoluteMagnitudeH = node.path("absolute_magnitude_h").asDouble();

                double estimatedDiameterMin = node.path("estimated_diameter")
                        .path("meters")
                        .path("estimated_diameter_min")
                        .asDouble();
                double estimatedDiameterMax = node.path("estimated_diameter")
                        .path("meters")
                        .path("estimated_diameter_max")
                        .asDouble();
                boolean isPotentiallyHazardousAsteroid = node.path("is_potentially_hazardous_asteroid")
                        .asBoolean();

                NearEarthObjectDTO neoDTO = NearEarthObjectDTO.builder()
                        .neoReferenceId(neoReferenceId)
                        .name(name)
                        .nameLimited(nameLimited)
                        .absoluteMagnitudeH(absoluteMagnitudeH)
                        .estimatedDiameterMin(estimatedDiameterMin)
                        .estimatedDiameterMax(estimatedDiameterMax)
                        .isPotentiallyHazardousAsteroid(isPotentiallyHazardousAsteroid)
                        .build();

                NearEarthObject neo = nearEarthObjectMapping.dtoToEntity(neoDTO);
                NearEarthObject savedNeo = nearEarthObjectRepository.save(neo);

                JsonNode closeApproaches = node.path("close_approach_data");

                for (JsonNode cANode : closeApproaches) {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(cANode.path("close_approach_date").asText());
                    double kilometersPerSecond = cANode.path("relative_velocity")
                            .path("kilometers_per_second")
                            .asDouble();
                    double kilometersMissDistance = cANode.path("miss_distance")
                            .path("kilometers")
                            .asDouble();
                    String orbitingBody = cANode.path("orbiting_body").asText();

                    CloseApproachDTO closeApproachDTO = CloseApproachDTO.builder()
                            .date(date)
                            .kilometersPerSecond(kilometersPerSecond)
                            .kilometersMissDistance(kilometersMissDistance)
                            .orbitingBody(orbitingBody)
                            .build();

                    CloseApproach closeApproach = closeApproachMapping.dtoToEntity(closeApproachDTO);
                    closeApproach.setNeo(savedNeo);
                    closeApproachesList.add(closeApproach);
                }

                closeApproachRepository.saveAll(closeApproachesList);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new ScraperServiceException("Erreur lors du parsing des données : " + e.getMessage());
        }
    }
}
