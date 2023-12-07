package com.felipeZe.FlashCardAPI.api.Repository;

import com.felipeZe.FlashCardAPI.api.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
