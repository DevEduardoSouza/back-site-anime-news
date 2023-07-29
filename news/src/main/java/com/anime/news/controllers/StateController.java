package com.anime.news.controllers;

import com.anime.news.entities.StateEntity;
import com.anime.news.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/state")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping("/")
    public List<StateEntity> findAll(){
        return stateService.findAll();
    }

    @PostMapping("/")
    public StateEntity save(@RequestBody StateEntity state){
        return stateService.save(state);
    }

    @PutMapping("/")
    public StateEntity update(@RequestBody StateEntity state){
        return stateService.update(state);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") UUID id){
        stateService.delete(id);
        return ResponseEntity.ok().build();
    }
}
