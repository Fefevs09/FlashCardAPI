package com.felipeZe.FlashCardAPI.Service;

import com.felipeZe.FlashCardAPI.api.Model.Users;
import com.felipeZe.FlashCardAPI.api.Repository.UserRepository;
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

    public Users createUser(UserDTO user) {
        Users newUser = new Users(user);
        this.userRepository.save(newUser);
        return newUser;
    }

    public Users findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
    public Users updateUser(Long id, UserDTO updatedUser) throws Exception {
        Users user = this.findUserById(id);
        user.setNome(updatedUser.nome());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
