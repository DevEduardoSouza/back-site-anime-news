package com.anime.news.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sources")
@Data
public class SourceEntity extends AbstractEntity {
  private String source;
}
