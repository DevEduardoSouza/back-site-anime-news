package com.anime.news.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class NewsEntity extends AbstractEntity{

    private String title;
    private String content;
    private String active;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity author;

}
