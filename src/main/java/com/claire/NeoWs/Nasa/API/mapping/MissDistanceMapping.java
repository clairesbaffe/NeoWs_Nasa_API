package com.claire.NeoWs.Nasa.API.mapping;

import com.claire.NeoWs.Nasa.API.dto.MissDistanceDTO;
import com.claire.NeoWs.Nasa.API.entity.MissDistance;
import org.springframework.stereotype.Component;

@Component
public class MissDistanceMapping {

    public MissDistance dtoToEntity(MissDistanceDTO missDistanceDTO){
        return MissDistance.builder()
                .astronomical(missDistanceDTO.astronomical())
                .lunar(missDistanceDTO.lunar())
                .kilometers(missDistanceDTO.kilometers())
                .miles(missDistanceDTO.miles())
                .build();
    }

    public MissDistanceDTO entityToDto(MissDistance missDistance){
        return MissDistanceDTO.builder()
                .astronomical(missDistance.getAstronomical())
                .lunar(missDistance.getLunar())
                .kilometers(missDistance.getKilometers())
                .miles(missDistance.getMiles())
                .build();
    }
}
