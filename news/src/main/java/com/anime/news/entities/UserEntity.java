package com.anime.news.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends AbstractEntity{
    private String Username;
    private Date birthDate;
    private String email;
    private String password;
    private String passwordResetCode;
    @Temporal(TemporalType.TIMESTAMP)
    private Date codeSentDate;
    @ManyToOne
    @JoinColumn(name = "idCity")
    private CityEntity city;
    private boolean active;
    private UserRole role;
}
