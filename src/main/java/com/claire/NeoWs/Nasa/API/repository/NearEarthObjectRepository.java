package com.claire.NeoWs.Nasa.API.repository;

import com.claire.NeoWs.Nasa.API.entity.NearEarthObject;
import org.springframework.data.repository.CrudRepository;

public interface NearEarthObjectRepository extends CrudRepository<NearEarthObject, Long> {
}
