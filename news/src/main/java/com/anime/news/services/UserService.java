package com.anime.news.services;

import com.anime.news.entities.StateEntity;
import com.anime.news.entities.UserEntity;
import com.anime.news.entities.UserRole;
import com.anime.news.repositories.StateRepository;
import com.anime.news.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity save (UserEntity user){
        user.setCreatedAt(new Date());

        user.setActive(true);
        UserEntity userNew = userRepository.saveAndFlush(user);
        return userNew;
    }

    public UserEntity update(UserEntity user){
        user.setUpdatedAt(new Date());
        return userRepository.saveAndFlush(user);
    }

    public void delete(UUID id){
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
