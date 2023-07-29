package com.anime.news.dtos;

import com.anime.news.entities.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
