package com.claire.NeoWs.Nasa.API.controller;

import com.claire.NeoWs.Nasa.API.entity.CloseApproach;
import com.claire.NeoWs.Nasa.API.service.ScraperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "scraper")
@RequiredArgsConstructor
public class ScraperController {

    private final ScraperService scraperService;

    @PostMapping(path = "/")
    public void scrape(@RequestParam(defaultValue = "1") int page){
        scraperService.scrape(page);
    }
}
