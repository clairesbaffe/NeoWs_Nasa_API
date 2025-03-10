package com.claire.NeoWs.Nasa.API.mapping;

import com.claire.NeoWs.Nasa.API.dto.NearEarthObjectDTO;
import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import org.springframework.stereotype.Component;

@Component
public class NearEarthObjectMapping {

    public NearEarthObject dtoToEntity(NearEarthObjectDTO nearEarthObjectDTO){
        return NearEarthObject.builder()
                .id(nearEarthObjectDTO.id())
                .neoReferenceId(nearEarthObjectDTO.neoReferenceId())
                .name(nearEarthObjectDTO.name())
                .nameLimited(nearEarthObjectDTO.nameLimited())
                .absoluteMagnitudeH(nearEarthObjectDTO.absoluteMagnitudeH())
                .estimatedDiameterMin(nearEarthObjectDTO.estimatedDiameterMin())
                .estimatedDiameterMax(nearEarthObjectDTO.estimatedDiameterMax())
                .isPotentiallyHazardousAsteroid(nearEarthObjectDTO.isPotentiallyHazardousAsteroid())
                .orbitDeterminationDate(nearEarthObjectDTO.orbitDeterminationDate())
                .firstObservationDate(nearEarthObjectDTO.firstObservationDate())
                .lastObservationDate(nearEarthObjectDTO.lastObservationDate())
                .dataArcInDays(nearEarthObjectDTO.dataArcInDays())
                .observationsUsed(nearEarthObjectDTO.observationsUsed())
                .orbitUncertainty(nearEarthObjectDTO.orbitUncertainty())
                .minimumOrbitIntersection(nearEarthObjectDTO.minimumOrbitIntersection())
                .eccentricity(nearEarthObjectDTO.eccentricity())
                .semiMajorAxis(nearEarthObjectDTO.semiMajorAxis())
                .inclination(nearEarthObjectDTO.inclination())
                .ascendingNodeLongitude(nearEarthObjectDTO.ascendingNodeLongitude())
                .orbitalPeriod(nearEarthObjectDTO.orbitalPeriod())
                .perihelionDistance(nearEarthObjectDTO.perihelionDistance())
                .perihelionArgument(nearEarthObjectDTO.perihelionArgument())
                .aphelionDistance(nearEarthObjectDTO.aphelionDistance())
                .perihelionTime(nearEarthObjectDTO.perihelionTime())
                .meanAnomaly(nearEarthObjectDTO.meanAnomaly())
                .meanMotion(nearEarthObjectDTO.meanMotion())
                .equinox(nearEarthObjectDTO.equinox())
                .build();
    }

    public NearEarthObjectDTO entityToDto(NearEarthObject nearEarthObject){
        return NearEarthObjectDTO.builder()
                .id(nearEarthObject.getId())
                .neoReferenceId(nearEarthObject.getNeoReferenceId())
                .name(nearEarthObject.getName())
                .nameLimited(nearEarthObject.getNameLimited())
                .absoluteMagnitudeH(nearEarthObject.getAbsoluteMagnitudeH())
                .estimatedDiameterMin(nearEarthObject.getEstimatedDiameterMin())
                .estimatedDiameterMax(nearEarthObject.getEstimatedDiameterMax())
                .isPotentiallyHazardousAsteroid(nearEarthObject.isPotentiallyHazardousAsteroid())
                .orbitDeterminationDate(nearEarthObject.getOrbitDeterminationDate())
                .firstObservationDate(nearEarthObject.getFirstObservationDate())
                .lastObservationDate(nearEarthObject.getLastObservationDate())
                .dataArcInDays(nearEarthObject.getDataArcInDays())
                .observationsUsed(nearEarthObject.getObservationsUsed())
                .orbitUncertainty(nearEarthObject.getOrbitUncertainty())
                .minimumOrbitIntersection(nearEarthObject.getMinimumOrbitIntersection())
                .eccentricity(nearEarthObject.getEccentricity())
                .semiMajorAxis(nearEarthObject.getSemiMajorAxis())
                .inclination(nearEarthObject.getInclination())
                .ascendingNodeLongitude(nearEarthObject.getAscendingNodeLongitude())
                .orbitalPeriod(nearEarthObject.getOrbitalPeriod())
                .perihelionDistance(nearEarthObject.getPerihelionDistance())
                .perihelionArgument(nearEarthObject.getPerihelionArgument())
                .aphelionDistance(nearEarthObject.getAphelionDistance())
                .perihelionTime(nearEarthObject.getPerihelionTime())
                .meanAnomaly(nearEarthObject.getMeanAnomaly())
                .meanMotion(nearEarthObject.getMeanMotion())
                .equinox(nearEarthObject.getEquinox())
                .build();
    }
}
