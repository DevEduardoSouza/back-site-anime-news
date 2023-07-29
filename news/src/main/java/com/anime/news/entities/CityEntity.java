package com.anime.news.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class CityEntity extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idState")
    private StateEntity state;
}
