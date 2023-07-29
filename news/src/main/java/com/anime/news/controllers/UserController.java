package com.anime.news.controllers;

import com.anime.news.entities.StateEntity;
import com.anime.news.entities.UserEntity;
import com.anime.news.services.StateService;
import com.anime.news.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @PostMapping("/")
    public UserEntity save(@RequestBody UserEntity user){
        return userService.save(user);
    }

    @PutMapping("/")
    public UserEntity update(@RequestBody UserEntity user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") UUID id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
