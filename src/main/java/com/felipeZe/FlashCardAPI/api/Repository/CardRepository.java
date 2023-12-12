package com.felipeZe.FlashCardAPI.api.Repository;

import com.felipeZe.FlashCardAPI.api.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findCardById(Long id);
    List<Card> findByDeckId(Long deckId);
}
