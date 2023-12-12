package com.felipeZe.FlashCardAPI.api.Repository;

import com.felipeZe.FlashCardAPI.api.Model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    Optional<Deck> findDeckById(Long id);
    List<Deck> findByUserId(Long userId);
}
