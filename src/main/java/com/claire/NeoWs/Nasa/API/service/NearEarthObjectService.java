package com.claire.NeoWs.Nasa.API.service;

import com.claire.NeoWs.Nasa.API.dto.NearEarthObjectDTO;
import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import com.claire.NeoWs.Nasa.API.mapping.NearEarthObjectMapping;
import com.claire.NeoWs.Nasa.API.repository.NearEarthObjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class NearEarthObjectService {

    private final NearEarthObjectMapping nearEarthObjectMapping;
    private final NearEarthObjectRepository nearEarthObjectRepository;

    public void add(NearEarthObjectDTO nearEarthObjectDTO){
        nearEarthObjectRepository.save(nearEarthObjectMapping.dtoToEntity(nearEarthObjectDTO));
    }

    public Iterable<NearEarthObjectDTO> getAll(){
        return StreamSupport.stream(nearEarthObjectRepository.findAll().spliterator(), false)
                .map(nearEarthObjectMapping::entityToDto)
                .collect(Collectors.toList());
    }

    public NearEarthObjectDTO getById(Long id){
        return nearEarthObjectRepository.findById(id)
                .map(nearEarthObjectMapping::entityToDto)
                .orElseThrow(() -> new EntityNotFoundException("Object not found with id: " + id));
    }

    public void update(Long id, NearEarthObjectDTO nearEarthObjectDTO) {
        if (!nearEarthObjectRepository.existsById(id)) {
            throw new EntityNotFoundException("NearEarthObject not found with id: " + id);
        }

        NearEarthObject nearEarthObject = nearEarthObjectMapping.dtoToEntity(nearEarthObjectDTO);
        nearEarthObject.setId(id);
        nearEarthObjectRepository.save(nearEarthObject);
    }

    public Optional<NearEarthObject> getByName(String name){
        return nearEarthObjectRepository.getFirstByName(name);
    }

}
