package com.felipeZe.FlashCardAPI.repositorys;

import com.felipeZe.FlashCardAPI.entities.deck.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    Optional<Deck> findDeckById(Long id);
    List<Deck> findByUserId(String userId);
}
