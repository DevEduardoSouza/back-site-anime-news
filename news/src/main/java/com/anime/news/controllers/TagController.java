package com.anime.news.controllers;

import com.anime.news.entities.TagEntity;
import com.anime.news.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/state")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public List<TagEntity> findAll() {
        return tagService.findAll();
    }

    @PostMapping("/")
    public TagEntity save(@RequestBody TagEntity tag) {
        return tagService.save(tag);
    }

    @PutMapping("/")
    public TagEntity update(@RequestBody TagEntity tag) {
        return tagService.update(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") UUID id) {
        tagService.delete(id);
        return ResponseEntity.ok().build();
    }
}
