package com.anime.news.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "states")
@Data
public class StateEntity extends AbstractEntity{
    private String acronym;
}
