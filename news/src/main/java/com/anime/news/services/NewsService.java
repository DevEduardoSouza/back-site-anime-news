package com.anime.news.services;

import com.anime.news.entities.CityEntity;
import com.anime.news.entities.NewsEntity;
import com.anime.news.repositories.CityRepository;
import com.anime.news.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<NewsEntity> findAll(){
        return newsRepository.findAll();
    }

    public NewsEntity save (NewsEntity news){
        news.setCreatedAt(new Date());
        NewsEntity cityNew = newsRepository.saveAndFlush(news);
        return cityNew;
    }

    public NewsEntity update(NewsEntity news){
        news.setUpdatedAt(new Date());
        return newsRepository.saveAndFlush(news);
    }

    public void delete(UUID id){
        NewsEntity news = newsRepository.findById(id).get();
        newsRepository.delete(news);
    }
}
