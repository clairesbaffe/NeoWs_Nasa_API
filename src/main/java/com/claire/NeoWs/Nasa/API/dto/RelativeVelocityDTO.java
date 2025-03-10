package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

@Builder
public record RelativeVelocityDTO(
        double kilometersPerSecond,
        double kilometersPerHour,
        double milesPerHour
) {
}
