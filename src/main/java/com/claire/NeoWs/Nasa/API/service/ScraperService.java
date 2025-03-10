package com.claire.NeoWs.Nasa.API.service;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.dto.MissDistanceDTO;
import com.claire.NeoWs.Nasa.API.dto.NearEarthObjectDTO;
import com.claire.NeoWs.Nasa.API.dto.RelativeVelocityDTO;
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

                // GET DATA FOR NEO OBJECT
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
                boolean isPotentiallyHazardousAsteroid = node.path("is_potentially_hazardous_asteroid").asBoolean();
                Date orbitDeterminationDate = new SimpleDateFormat("yyyy-MM-dd").parse(node.path("orbital_data")
                        .path("orbit_determination_date")
                        .asText());
                Date firstObservationDate = new SimpleDateFormat("yyyy-MM-dd").parse(node.path("orbital_data")
                        .path("first_observation_date")
                        .asText());
                Date lastObservationDate = new SimpleDateFormat("yyyy-MM-dd").parse(node.path("orbital_data")
                        .path("last_observation_date")
                        .asText());
                int dataArcInDays = node.path("orbital_data").path("data_arc_in_days").asInt();
                int observationsUsed = node.path("orbital_data").path("observations_used").asInt();
                String orbitUncertainty = node.path("orbital_data").path("orbit_uncertainty").asText();
                double minimumOrbitIntersection = node.path("orbital_data").path("minimum_orbit_intersection").asDouble();
                double eccentricity = node.path("orbital_data").path("eccentricity").asDouble();
                double semiMajorAxis = node.path("orbital_data").path("semi_major_axis").asDouble();
                double inclination = node.path("orbital_data").path("inclination").asDouble();
                double ascendingNodeLongitude = node.path("orbital_data").path("ascending_node_longitude").asDouble();
                double orbitalPeriod = node.path("orbital_data").path("orbital_period").asDouble();
                double perihelionDistance = node.path("orbital_data").path("perihelion_distance").asDouble();
                double perihelionArgument = node.path("orbital_data").path("perihelion_argument").asDouble();
                double aphelionDistance = node.path("orbital_data").path("aphelion_distance").asDouble();
                double perihelionTime = node.path("orbital_data").path("perihelion_time").asDouble();
                double meanAnomaly = node.path("orbital_data").path("mean_anomaly").asDouble();
                double meanMotion = node.path("orbital_data").path("mean_motion").asDouble();
                double equinox = node.path("orbital_data").path("equinox").asDouble();

                // BUILD AND SAVE NEO OBJECT
                NearEarthObjectDTO neoDTO = NearEarthObjectDTO.builder()
                        .neoReferenceId(neoReferenceId)
                        .name(name)
                        .nameLimited(nameLimited)
                        .absoluteMagnitudeH(absoluteMagnitudeH)
                        .estimatedDiameterMin(estimatedDiameterMin)
                        .estimatedDiameterMax(estimatedDiameterMax)
                        .isPotentiallyHazardousAsteroid(isPotentiallyHazardousAsteroid)
                        .orbitDeterminationDate(orbitDeterminationDate)
                        .firstObservationDate(firstObservationDate)
                        .lastObservationDate(lastObservationDate)
                        .dataArcInDays(dataArcInDays)
                        .observationsUsed(observationsUsed)
                        .orbitUncertainty(orbitUncertainty)
                        .minimumOrbitIntersection(minimumOrbitIntersection)
                        .eccentricity(eccentricity)
                        .semiMajorAxis(semiMajorAxis)
                        .inclination(inclination)
                        .ascendingNodeLongitude(ascendingNodeLongitude)
                        .orbitalPeriod(orbitalPeriod)
                        .perihelionDistance(perihelionDistance)
                        .perihelionArgument(perihelionArgument)
                        .aphelionDistance(aphelionDistance)
                        .perihelionTime(perihelionTime)
                        .meanAnomaly(meanAnomaly)
                        .meanMotion(meanMotion)
                        .equinox(equinox)
                        .build();

                NearEarthObject neo = nearEarthObjectMapping.dtoToEntity(neoDTO);
                NearEarthObject savedNeo = nearEarthObjectRepository.save(neo);


                JsonNode closeApproaches = node.path("close_approach_data");

                for (JsonNode cANode : closeApproaches) {

                    // GET DATA FOR RELATIVE VELOCITY
                    double kilometersPerSecond = cANode.path("relative_velocity")
                            .path("kilometers_per_second")
                            .asDouble();
                    double kilometersPerHour = cANode.path("relative_velocity")
                            .path("kilometers_per_hour")
                            .asDouble();
                    double milesPerHour = cANode.path("relative_velocity")
                            .path("miles_per_hour")
                            .asDouble();

                    RelativeVelocityDTO relativeVelocityDTO = RelativeVelocityDTO.builder()
                            .kilometersPerSecond(kilometersPerSecond)
                            .kilometersPerHour(kilometersPerHour)
                            .milesPerHour(milesPerHour)
                            .build();

                    // GET DATA FOR MISS DISTANCE
                    double astronomical = cANode.path("miss_distance")
                            .path("astronomical")
                            .asDouble();
                    double lunar = cANode.path("miss_distance")
                            .path("lunar")
                            .asDouble();
                    double kilometers = cANode.path("miss_distance")
                            .path("kilometers")
                            .asDouble();
                    double miles = cANode.path("miss_distance")
                            .path("miles")
                            .asDouble();

                    MissDistanceDTO missDistanceDTO = MissDistanceDTO.builder()
                            .astronomical(astronomical)
                            .lunar(lunar)
                            .kilometers(kilometers)
                            .miles(miles)
                            .build();

                    // GET DATA FOR CLOSE APPROACH
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(cANode.path("close_approach_date").asText());
                    String orbitingBody = cANode.path("orbiting_body").asText();

                    CloseApproachDTO closeApproachDTO = CloseApproachDTO.builder()
                            .date(date)
                            .orbitingBody(orbitingBody)
                            .relativeVelocity(relativeVelocityDTO)
                            .missDistance(missDistanceDTO)
                            .build();

                    // SAVE CLOSE APPROACH
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
