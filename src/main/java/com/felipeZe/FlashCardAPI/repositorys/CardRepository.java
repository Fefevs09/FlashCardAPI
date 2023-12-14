package com.felipeZe.FlashCardAPI.repositorys;

import com.felipeZe.FlashCardAPI.entities.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findCardById(Long id);
    List<Card> findByDeckId(Long deckId);
}
