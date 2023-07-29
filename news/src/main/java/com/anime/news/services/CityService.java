package com.anime.news.services;

import com.anime.news.entities.CityEntity;
import com.anime.news.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<CityEntity> findAll(){
        return cityRepository.findAll();
    }

    public CityEntity save (CityEntity city){
        city.setCreatedAt(new Date());
        CityEntity cityNew = cityRepository.saveAndFlush(city);
        return cityNew;
    }

    public CityEntity update(CityEntity city){
        city.setUpdatedAt(new Date());
        return cityRepository.saveAndFlush(city);
    }

    public void delete(UUID id){
        CityEntity city = cityRepository.findById(id).get();
        cityRepository.delete(city);
    }
}
