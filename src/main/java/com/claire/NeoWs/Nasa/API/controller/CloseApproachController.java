package com.claire.NeoWs.Nasa.API.controller;

import com.claire.NeoWs.Nasa.API.dto.CloseApproachDTO;
import com.claire.NeoWs.Nasa.API.service.CloseApproachService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/close_approach")
@RequiredArgsConstructor
public class CloseApproachController {

    private final CloseApproachService closeApproachService;

    @PostMapping(path = "/")
    public void add(@RequestBody CloseApproachDTO closeApproachDTO){
        closeApproachService.add(closeApproachDTO);
    }

    @GetMapping(path = "/")
    public Iterable<CloseApproachDTO> getAll(){
        return closeApproachService.getAll();
    }

    @GetMapping(path = "/{id}")
    public CloseApproachDTO getById(@PathVariable Long id){
        return closeApproachService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody CloseApproachDTO closeApproachDTO){
        closeApproachService.update(id, closeApproachDTO);
    }
}
