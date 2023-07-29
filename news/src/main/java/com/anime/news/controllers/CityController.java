package com.anime.news.controllers;

import com.anime.news.entities.CityEntity;
import com.anime.news.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public List<CityEntity> findAll(){
        return cityService.findAll();
    }

    @PostMapping("/")
    public CityEntity save(@RequestBody CityEntity city){
        return cityService.save(city);
    }

    @PutMapping("/")
    public CityEntity update(@RequestBody CityEntity city){
        return cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") UUID id){
        cityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
