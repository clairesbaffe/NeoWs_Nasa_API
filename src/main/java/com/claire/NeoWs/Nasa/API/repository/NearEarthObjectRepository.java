package com.claire.NeoWs.Nasa.API.repository;

import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NearEarthObjectRepository extends CrudRepository<NearEarthObject, Long> {

    public Optional<NearEarthObject> getFirstByName(String name);
}
