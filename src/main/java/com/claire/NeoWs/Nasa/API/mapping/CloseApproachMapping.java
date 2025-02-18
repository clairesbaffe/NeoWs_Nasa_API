package com.claire.NeoWs.Nasa.API.mapping;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.entity.CloseApproach;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CloseApproachMapping {

    private final NearEarthObjectMapping nearEarthObjectMapping;

    public CloseApproach dtoToEntity(CloseApproachDTO closeApproachDTO){
        return CloseApproach.builder()
                .date(closeApproachDTO.date())
                .kilometersPerSecond(closeApproachDTO.kilometersPerSecond())
                .kilometersMissDistance(closeApproachDTO.kilometersMissDistance())
                .neo(closeApproachDTO.neo() != null ? nearEarthObjectMapping.dtoToEntity(closeApproachDTO.neo()) : null)
                .build();
    }

    public CloseApproachDTO entityToDto(CloseApproach closeApproach){
        return CloseApproachDTO.builder()
                .date(closeApproach.getDate())
                .kilometersPerSecond(closeApproach.getKilometersPerSecond())
                .kilometersMissDistance(closeApproach.getKilometersMissDistance())
                .neo(closeApproach.getNeo() != null ? nearEarthObjectMapping.entityToDto(closeApproach.getNeo()) : null)
                .build();
    }
}
