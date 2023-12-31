package com.anime.news.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity extends AbstractEntity implements UserDetails {
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

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<NewsEntity> newsList;

    public void addNews(NewsEntity news) {
        newsList.add(news);
        news.setAuthor(this);
    }

    public void removeNews(NewsEntity news) {
        newsList.remove(news);
        news.setAuthor(null);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN){
            return List.of( new SimpleGrantedAuthority("ROLE_ADMIN"),
                            new SimpleGrantedAuthority("ROLE_STAFF"),
                            new SimpleGrantedAuthority("ROLE_USER"));
        }else if (this.role == UserRole.STAFF){
            return List.of(new SimpleGrantedAuthority("ROLE_STAFF"),
                           new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
