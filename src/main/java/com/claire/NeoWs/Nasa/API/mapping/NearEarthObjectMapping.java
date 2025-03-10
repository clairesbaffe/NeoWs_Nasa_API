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
                .build();
    }
}
