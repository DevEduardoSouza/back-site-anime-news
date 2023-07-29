package com.anime.news.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
