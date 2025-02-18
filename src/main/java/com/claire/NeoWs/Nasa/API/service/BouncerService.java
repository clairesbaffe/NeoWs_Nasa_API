package com.claire.NeoWs.Nasa.API.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BouncerService {

    @Value("${NASA_API_KEY}")
    private String nasaApiKey;

    private final RestClient restClient;

    public String getByDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start_date,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end_date){
        return restClient
                .get()
                .uri("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + start_date + "&end_date=" + end_date + "&api_key=" + nasaApiKey)
                .retrieve()
                .body(String.class);
    }

    public String getById(Long id){
        return restClient
                .get()
                .uri("https://api.nasa.gov/neo/rest/v1/neo/" + id + "?api_key=" + nasaApiKey)
                .retrieve()
                .body(String.class);
    }
}
