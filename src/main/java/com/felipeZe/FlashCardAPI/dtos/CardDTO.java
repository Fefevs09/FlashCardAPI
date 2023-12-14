package com.felipeZe.FlashCardAPI.dtos;

import com.felipeZe.FlashCardAPI.entities.card.Feedback;

public record CardDTO(String pergunta, String reposta, Feedback feedback, Long deckId) {
}
