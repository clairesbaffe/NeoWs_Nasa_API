package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

@Builder
public record NearEarthObjectDTO(
        Long id,
        int neoReferenceId,
        String name,
        String nameLimited,
        double absoluteMagnitudeH,
        double estimatedDiameterMin,
        double estimatedDiameterMax,
        boolean isPotentiallyHazardousAsteroid) {
}
