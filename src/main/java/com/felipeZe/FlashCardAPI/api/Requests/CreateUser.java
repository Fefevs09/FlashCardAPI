package com.felipeZe.FlashCardAPI.api.Requests;

import com.felipeZe.FlashCardAPI.api.Model.User;

public record CreateUser(String nome, String email, String senha) {
    public User createUser() {
        User user = new User();

        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);

        return user;
    }
}
