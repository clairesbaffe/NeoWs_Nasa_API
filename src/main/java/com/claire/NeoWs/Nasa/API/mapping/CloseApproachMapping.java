package com.claire.NeoWs.Nasa.API.mapping;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.entity.CloseApproach;
import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import com.claire.NeoWs.Nasa.API.repository.NearEarthObjectRepository;
import com.claire.NeoWs.Nasa.API.service.NearEarthObjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CloseApproachMapping {

    private final NearEarthObjectMapping nearEarthObjectMapping;
    private final NearEarthObjectService nearEarthObjectService;

    public CloseApproach dtoToEntity(CloseApproachDTO closeApproachDTO){
        return CloseApproach.builder()
                .id(closeApproachDTO.id())
                .date(closeApproachDTO.date())
                .kilometersPerSecond(closeApproachDTO.kilometersPerSecond())
                .kilometersMissDistance(closeApproachDTO.kilometersMissDistance())
                .orbitingBody(closeApproachDTO.orbitingBody())
                .neo(closeApproachDTO.neo() != null ? nearEarthObjectMapping.dtoToEntity(closeApproachDTO.neo()) : null)
                .build();
    }

    public CloseApproachDTO entityToDto(CloseApproach closeApproach){
        return CloseApproachDTO.builder()
                .id(closeApproach.getId())
                .date(closeApproach.getDate())
                .kilometersPerSecond(closeApproach.getKilometersPerSecond())
                .kilometersMissDistance(closeApproach.getKilometersMissDistance())
                .orbitingBody(closeApproach.getOrbitingBody())
                .neo(closeApproach.getNeo() != null ? nearEarthObjectMapping.entityToDto(closeApproach.getNeo()) : null)
                .build();
    }
}
