package com.anime.news.repositories;

import com.anime.news.entities.NewsEntity;
import com.anime.news.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, UUID> {
}
