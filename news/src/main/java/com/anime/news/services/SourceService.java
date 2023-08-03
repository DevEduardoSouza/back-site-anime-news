package com.anime.news.services;

import com.anime.news.entities.SourceEntity;
import com.anime.news.repositories.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SourceService {
    @Autowired
    private SourceRepository tagRepository;

    public List<SourceEntity> findAll() {
        return tagRepository.findAll();
    }

    public SourceEntity save(SourceEntity source) {
        source.setCreatedAt(new Date());
        SourceEntity tagNew = tagRepository.saveAndFlush(source);
        return tagNew;
    }

    public SourceEntity update(SourceEntity source) {
        source.setUpdatedAt(new Date());
        return tagRepository.saveAndFlush(source);
    }

    public void delete(UUID id) {
        SourceEntity source = tagRepository.findById(id).get();
        tagRepository.delete(source);
    }
}
