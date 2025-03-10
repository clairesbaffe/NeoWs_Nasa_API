package com.claire.NeoWs.Nasa.API.mapping;

import com.claire.NeoWs.Nasa.API.dto.RelativeVelocityDTO;
import com.claire.NeoWs.Nasa.API.entity.RelativeVelocity;
import org.springframework.stereotype.Component;

@Component
public class RelativeVelocityMapping {

    public RelativeVelocity dtoToEntity(RelativeVelocityDTO relativeVelocityDTO){
        return RelativeVelocity.builder()
                .kilometersPerSecond(relativeVelocityDTO.kilometersPerSecond())
                .kilometersPerHour(relativeVelocityDTO.kilometersPerHour())
                .milesPerHour(relativeVelocityDTO.milesPerHour())
                .build();
    }

    public RelativeVelocityDTO entityToDto(RelativeVelocity relativeVelocity){
        return RelativeVelocityDTO.builder()
                .kilometersPerSecond(relativeVelocity.getKilometersPerSecond())
                .kilometersPerHour(relativeVelocity.getKilometersPerHour())
                .milesPerHour(relativeVelocity.getMilesPerHour())
                .build();
    }
}
