package com.felipeZe.FlashCardAPI.repositorys;

import com.felipeZe.FlashCardAPI.entities.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String > {
    Optional<Users> findUserById(String id);
    UserDetails findUsersByEmail(String email);

}
