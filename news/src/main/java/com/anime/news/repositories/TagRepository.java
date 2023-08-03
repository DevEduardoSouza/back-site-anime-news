package com.anime.news.repositories;

import com.anime.news.entities.CategoryEntity;
import com.anime.news.entities.StateEntity;
import com.anime.news.entities.TagEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, UUID> {
}
