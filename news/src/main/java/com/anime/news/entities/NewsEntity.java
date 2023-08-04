package com.anime.news.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class NewsEntity extends AbstractEntity{

    private String title;
    private String content;
    private boolean active;
    private String imageUrl;
    private int like_count;
    private int views_count;
    private int comments_count;
    private int shares_count;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "id_source")
    private SourceEntity source;

}
