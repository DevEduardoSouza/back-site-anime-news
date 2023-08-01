package com.anime.news.services;

import com.anime.news.dtos.UpdateDTO;
import com.anime.news.entities.CityEntity;
import com.anime.news.entities.NewsEntity;
import com.anime.news.entities.UserEntity;
import com.anime.news.entities.UserRole;
import com.anime.news.repositories.CityRepository;
import com.anime.news.repositories.NewsRepository;
import com.anime.news.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public List<NewsEntity> findAll(){
        return newsRepository.findAll();
    }
    public List<NewsEntity> findAllNewsAuthor(UUID id){
        return newsRepository.findByAuthorId(id);
    }


    public NewsEntity save (NewsEntity news){

        if (news.getAuthor().isActive()) {
            news.setCreatedAt(new Date());
            //news.getAuthor().addNews(news);
            NewsEntity cityNew = newsRepository.save(news);
            return cityNew;
        } else {
            throw new IllegalArgumentException("O autor está inativo e não pode criar notícias.");
        }
    }


    public ResponseEntity<?> update(NewsEntity news) {
        Optional<NewsEntity> optionalNews = newsRepository.findById(news.getId());
        NewsEntity newsEntity = optionalNews.get();

    //Buscar a Role do user que quer editar
        Optional<UserEntity> optionalUser= userRepository.findById(news.getAuthor().getId());
        UserEntity newUser = optionalUser.get();

        if (optionalNews.isPresent()) {
            // Verificar se o ID do autor da notícia original é igual ao ID do autor da notícia atualizada, Um admin pode apagar qualquer news
            if (newsEntity.getAuthor().getId().equals(news.getAuthor().getId()) || newUser.getRole().equals(UserRole.ADMIN) ) {
                news.setUpdatedAt(new Date());
                newsRepository.saveAndFlush(news);
                return ResponseEntity.status(HttpStatus.OK).body(new UpdateDTO("Voce pode editar"));
            } else
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new UpdateDTO("Você NÃO postou esta notícia."));
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UpdateDTO("A notícia com o ID fornecido não foi encontrada."));
    }

    public void delete(UUID id){
        NewsEntity news = newsRepository.findById(id).get();
        newsRepository.delete(news);
    }
}
