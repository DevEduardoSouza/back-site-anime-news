package com.anime.news.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class NewsEntity extends AbstractEntity{

    private String title;
    private String content;
    private String active;

}
