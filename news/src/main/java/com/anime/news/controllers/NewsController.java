package com.anime.news.controllers;

import com.anime.news.entities.NewsEntity;
import com.anime.news.entities.StateEntity;
import com.anime.news.services.NewsService;
import com.anime.news.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


// ADMIN e STAFF -> post , USER -> GET
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public List<NewsEntity> findAll(){
        return newsService.findAll();
    }

//    Retornar todas as postagem dos autores
    @GetMapping("/{id}")
    public List<NewsEntity> findAllNewsAuthor(@PathVariable("id") UUID id){
        return newsService.findAllNewsAuthor(id);
    }

    @PostMapping("/")
    public NewsEntity save(@RequestBody NewsEntity news){
        return newsService.save(news);
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody NewsEntity news){
        return newsService.update(news);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        newsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
