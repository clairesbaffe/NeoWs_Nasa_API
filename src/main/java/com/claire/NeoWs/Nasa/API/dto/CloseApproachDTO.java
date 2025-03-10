package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record CloseApproachDTO(
        Long id,
        Date date,
        String orbitingBody,
        RelativeVelocityDTO relativeVelocity,
        MissDistanceDTO missDistance,
        NearEarthObjectDTO neo
) {
}
