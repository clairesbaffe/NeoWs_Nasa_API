package com.claire.NeoWs.Nasa.API.mapping;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.entity.CloseApproach;
import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import com.claire.NeoWs.Nasa.API.repository.NearEarthObjectRepository;
import com.claire.NeoWs.Nasa.API.service.NearEarthObjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CloseApproachMapping {

    private final NearEarthObjectMapping nearEarthObjectMapping;
    private final RelativeVelocityMapping relativeVelocityMapping;
    private final MissDistanceMapping missDistanceMapping;

    public CloseApproach dtoToEntity(CloseApproachDTO closeApproachDTO){
        return CloseApproach.builder()
                .id(closeApproachDTO.id())
                .date(closeApproachDTO.date())
                .orbitingBody(closeApproachDTO.orbitingBody())
                .relativeVelocity(closeApproachDTO.relativeVelocity() != null ? relativeVelocityMapping.dtoToEntity(closeApproachDTO.relativeVelocity()) : null)
                .missDistance(closeApproachDTO.missDistance() != null ? missDistanceMapping.dtoToEntity(closeApproachDTO.missDistance()) : null)
                .neo(closeApproachDTO.neo() != null ? nearEarthObjectMapping.dtoToEntity(closeApproachDTO.neo()) : null)
                .build();
    }

    public CloseApproachDTO entityToDto(CloseApproach closeApproach){
        return CloseApproachDTO.builder()
                .id(closeApproach.getId())
                .date(closeApproach.getDate())
                .orbitingBody(closeApproach.getOrbitingBody())
                .relativeVelocity(closeApproach.getRelativeVelocity() != null ? relativeVelocityMapping.entityToDto(closeApproach.getRelativeVelocity()) : null)
                .missDistance(closeApproach.getMissDistance() != null ? missDistanceMapping.entityToDto(closeApproach.getMissDistance()) : null)
                .neo(closeApproach.getNeo() != null ? nearEarthObjectMapping.entityToDto(closeApproach.getNeo()) : null)
                .build();
    }
}
