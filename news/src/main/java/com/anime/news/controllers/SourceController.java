package com.anime.news.controllers;

import com.anime.news.entities.SourceEntity;
import com.anime.news.services.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/source")
public class SourceController {
    @Autowired
    private SourceService tagService;

    @GetMapping("/")
    public List<SourceEntity> findAll() {
        return tagService.findAll();
    }

    @PostMapping("/")
    public SourceEntity save(@RequestBody SourceEntity source) {
        return tagService.save(source);
    }

    @PutMapping("/")
    public SourceEntity update(@RequestBody SourceEntity source) {
        return tagService.update(source);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") UUID id) {
        tagService.delete(id);
        return ResponseEntity.ok().build();
    }
}
