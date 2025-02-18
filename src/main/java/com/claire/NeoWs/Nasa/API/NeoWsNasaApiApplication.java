package com.claire.NeoWs.Nasa.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class NeoWsNasaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeoWsNasaApiApplication.class, args);
	}

	@Bean
	public RestClient restClient() {
		return RestClient.create();
	}


}
