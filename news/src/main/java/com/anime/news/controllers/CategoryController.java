package com.anime.news.controllers;

import com.anime.news.entities.CategoryEntity;
import com.anime.news.entities.StateEntity;
import com.anime.news.services.CategoryService;
import com.anime.news.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryEntity> findAll() {
        return categoryService.findAll();
    }

    @PostMapping("/")
    public CategoryEntity save(@RequestBody CategoryEntity category) {
        return categoryService.save(category);
    }

    @PutMapping("/")
    public CategoryEntity update(@RequestBody CategoryEntity category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") UUID id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
