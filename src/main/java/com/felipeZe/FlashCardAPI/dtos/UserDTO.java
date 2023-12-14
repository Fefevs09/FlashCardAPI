package com.felipeZe.FlashCardAPI.dtos;

import com.felipeZe.FlashCardAPI.entities.user.UserRole;

public record UserDTO(String name, String email, String password, UserRole role) {
}
