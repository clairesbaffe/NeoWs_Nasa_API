package com.claire.NeoWs.Nasa.API.controller;

import com.claire.NeoWs.Nasa.API.service.BouncerService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/bouncer")
@RequiredArgsConstructor
public class BouncerController {

    private final BouncerService bouncerService;

    @GetMapping(path = "/")
    public String getByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start_date,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end_date){
        return bouncerService.getByDate(start_date, end_date);
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id){
        return bouncerService.getById(id);
    }
}
