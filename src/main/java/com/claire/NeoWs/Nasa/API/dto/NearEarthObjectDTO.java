package com.claire.NeoWs.Nasa.API.dto;

import lombok.Builder;

import java.util.Date;
import java.util.List;

@Builder
public record NearEarthObjectDTO(
        Long id,
        int neoReferenceId,
        String name,
        String nameLimited,

        double absoluteMagnitudeH,
        double estimatedDiameterMin,
        double estimatedDiameterMax,
        boolean isPotentiallyHazardousAsteroid,
        Date orbitDeterminationDate,
        Date firstObservationDate,
        Date lastObservationDate,

        int dataArcInDays,
        int observationsUsed,
        String orbitUncertainty,
        double minimumOrbitIntersection,

        double eccentricity,
        double semiMajorAxis,
        double inclination,
        double ascendingNodeLongitude,
        double orbitalPeriod,

        double perihelionDistance,
        double perihelionArgument,
        double aphelionDistance,
        double perihelionTime,

        double meanAnomaly,
        double meanMotion,
        double equinox
) {
}
