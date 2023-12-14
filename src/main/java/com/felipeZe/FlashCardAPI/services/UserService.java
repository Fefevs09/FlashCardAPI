package com.felipeZe.FlashCardAPI.services;

import com.felipeZe.FlashCardAPI.entities.user.Users;
import com.felipeZe.FlashCardAPI.repositorys.UserRepository;
import com.felipeZe.FlashCardAPI.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> listUsers() {
        return this.userRepository.findAll();
    }

    public Users findUserById(String id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
}
