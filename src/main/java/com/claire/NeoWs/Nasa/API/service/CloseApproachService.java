package com.claire.NeoWs.Nasa.API.service;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.dto.NearEarthObjectDTO;
import com.claire.NeoWs.Nasa.API.entity.CloseApproach;
import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import com.claire.NeoWs.Nasa.API.mapping.CloseApproachMapping;
import com.claire.NeoWs.Nasa.API.mapping.NearEarthObjectMapping;
import com.claire.NeoWs.Nasa.API.repository.CloseApproachRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CloseApproachService {

    private final CloseApproachMapping closeApproachMapping;
    private final CloseApproachRepository closeApproachRepository;
    private final NearEarthObjectService nearEarthObjectService;
    private final NearEarthObjectMapping nearEarthObjectMapping;

    public void add(CloseApproachDTO closeApproachDTO){
        NearEarthObject neo = null;

        if (closeApproachDTO.neo() != null && closeApproachDTO.neo().id() != null) {
            neo = nearEarthObjectMapping.dtoToEntity(nearEarthObjectService.getById(closeApproachDTO.neo().id()));
        }

        CloseApproach closeApproach = closeApproachMapping.dtoToEntity(closeApproachDTO);
        closeApproachRepository.save(closeApproach);
    }

    public Iterable<CloseApproachDTO> getAll(){
        return StreamSupport.stream(closeApproachRepository.findAll().spliterator(), false)
                .map(closeApproachMapping::entityToDto)
                .collect(Collectors.toList());
    }

    public CloseApproachDTO getById(Long id){
        return closeApproachRepository.findById(id)
                .map(closeApproachMapping::entityToDto)
                .orElseThrow(() -> new EntityNotFoundException("Object not found with id: " + id));
    }

    public void update(Long id, CloseApproachDTO closeApproachDTO) {
        if (!closeApproachRepository.existsById(id)) {
            throw new EntityNotFoundException("NearEarthObject not found with id: " + id);
        }

        CloseApproach closeApproach = closeApproachMapping.dtoToEntity(closeApproachDTO);
        closeApproach.setId(id);
        closeApproachRepository.save(closeApproach);
    }
}
