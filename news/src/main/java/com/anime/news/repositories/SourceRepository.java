package com.anime.news.repositories;

import com.anime.news.entities.SourceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SourceRepository extends JpaRepository<SourceEntity, UUID> {
}
