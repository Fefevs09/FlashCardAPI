package com.felipeZe.FlashCardAPI.api.Repository;

import com.felipeZe.FlashCardAPI.api.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUserById(Long id);

}
