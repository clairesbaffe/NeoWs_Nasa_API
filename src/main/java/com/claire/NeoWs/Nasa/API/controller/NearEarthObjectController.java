package com.claire.NeoWs.Nasa.API.controller;

import com.claire.NeoWs.Nasa.API.dto.NearEarthObjectDTO;
import com.claire.NeoWs.Nasa.API.service.NearEarthObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/near_earth_object")
@RequiredArgsConstructor
public class NearEarthObjectController {

    private final NearEarthObjectService nearEarthObjectService;

    @PostMapping(path = "/")
    public void add(@RequestBody NearEarthObjectDTO nearEarthObjectDTO){
        nearEarthObjectService.add(nearEarthObjectDTO);
    }

    @GetMapping(path = "/")
    public Iterable<NearEarthObjectDTO> getAll(){
        return nearEarthObjectService.getAll();
    }

    @GetMapping(path = "/{id}")
    public NearEarthObjectDTO getById(@PathVariable Long id){
        return nearEarthObjectService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody NearEarthObjectDTO nearEarthObjectDTO){
        nearEarthObjectService.update(id, nearEarthObjectDTO);
    }
}
