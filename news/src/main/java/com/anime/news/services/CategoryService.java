package com.anime.news.services;

import com.anime.news.entities.CategoryEntity;
import com.anime.news.entities.StateEntity;
import com.anime.news.repositories.CategoryRepository;
import com.anime.news.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public CategoryEntity save (CategoryEntity category){
        category.setCreatedAt(new Date());
        CategoryEntity categoryNew = categoryRepository.saveAndFlush(category);
        return categoryNew;
    }

    public CategoryEntity update(CategoryEntity category){
        category.setUpdatedAt(new Date());
        return categoryRepository.saveAndFlush(category);
    }

    public void delete(UUID id){
        CategoryEntity category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }
}
