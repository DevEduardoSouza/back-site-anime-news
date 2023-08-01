package com.anime.news.services;

import com.anime.news.entities.CityEntity;
import com.anime.news.entities.NewsEntity;
import com.anime.news.repositories.CityRepository;
import com.anime.news.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<NewsEntity> findAll(){
        return newsRepository.findAll();
    }

    public NewsEntity save (NewsEntity news){

        if (news.getAuthor().isActive()) {
            news.setCreatedAt(new Date());
            //news.getAuthor().addNews(news);
            NewsEntity cityNew = newsRepository.saveAndFlush(news);
            return cityNew;
        } else {
            throw new IllegalArgumentException("O autor está inativo e não pode criar notícias.");
        }
    }

    public ResponseEntity<?> update(NewsEntity news) {
        Optional<NewsEntity> optionalNews = newsRepository.findById(news.getId());

        if (optionalNews.isPresent()) {
            NewsEntity newsEntity = optionalNews.get();

            // Verificar se o ID do autor da notícia original é igual ao ID do autor da notícia atualizada
            if (newsEntity.getAuthor().getId().equals(news.getAuthor().getId())) {
                news.setUpdatedAt(new Date());
                newsRepository.saveAndFlush(news);
                return ResponseEntity.status(HttpStatus.OK).body("Você que postou.");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Você NÃO postou esta notícia.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A notícia com o ID fornecido não foi encontrada.");
        }
    }

    public void delete(UUID id){
        NewsEntity news = newsRepository.findById(id).get();
        newsRepository.delete(news);
    }
}
