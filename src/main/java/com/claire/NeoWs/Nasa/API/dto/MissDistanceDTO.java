package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

@Builder
public record MissDistanceDTO(
        double astronomical,
        double lunar,
        double kilometers,
        double miles
) {
}
