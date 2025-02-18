package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record CloseApproachDTO(
        Date date,
        double kilometersPerSecond,
        double kilometersMissDistance,
        NearEarthObjectDTO neo) {
}
