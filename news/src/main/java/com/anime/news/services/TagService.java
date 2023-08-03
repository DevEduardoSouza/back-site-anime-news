package com.anime.news.services;

import com.anime.news.entities.TagEntity;
import com.anime.news.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<TagEntity> findAll() {
        return tagRepository.findAll();
    }

    public TagEntity save(TagEntity tag) {
        tag.setCreatedAt(new Date());
        TagEntity tagNew = tagRepository.saveAndFlush(tag);
        return tagNew;
    }

    public TagEntity update(TagEntity tag) {
        tag.setUpdatedAt(new Date());
        return tagRepository.saveAndFlush(tag);
    }

    public void delete(UUID id) {
        TagEntity tag = tagRepository.findById(id).get();
        tagRepository.delete(tag);
    }
}
