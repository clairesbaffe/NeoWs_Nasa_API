package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record CloseApproachDTO(
        Long id,
        Date date,
        double kilometersPerSecond,
        double kilometersMissDistance,
        String orbitingBody,
        NearEarthObjectDTO neo) {
}
