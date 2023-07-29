package com.anime.news.services;

import com.anime.news.entities.StateEntity;
import com.anime.news.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<StateEntity> findAll(){
        return stateRepository.findAll();
    }

    public StateEntity save (StateEntity state){
        state.setCreatedAt(new Date());
        StateEntity stateNew = stateRepository.saveAndFlush(state);
        return stateNew;
    }

    public StateEntity update(StateEntity state){
        state.setUpdatedAt(new Date());
        return stateRepository.saveAndFlush(state);
    }

    public void delete(UUID id){
        StateEntity state = stateRepository.findById(id).get();
        stateRepository.delete(state);
    }
}
