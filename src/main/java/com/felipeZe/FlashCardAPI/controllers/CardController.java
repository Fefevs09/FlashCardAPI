package com.felipeZe.FlashCardAPI.controllers;

import com.felipeZe.FlashCardAPI.services.CardService;
import com.felipeZe.FlashCardAPI.entities.card.Card;
import com.felipeZe.FlashCardAPI.dtos.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

//    @GetMapping
//    public ResponseEntity<List<Card>> listCards() {
//        List<Card> cards = cardService.listAllCards();
//
//        return new ResponseEntity<>(cards, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable Long id) {
        Card card = cardService.findCardById(id);

        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping("/deck/{deckId}")
    public ResponseEntity<List<Card>> listCardsById(@PathVariable Long deckId) {
        List<Card> cards = this.cardService.listCardsByDeck(deckId);

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody CardDTO createCard) {
        Card card = cardService.createCard(createCard);

        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody CardDTO updateCard) {

        Card card = cardService.findCardById(id);
        this.cardService.updateCard(id, updateCard);

        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> deleteCard(@PathVariable Long id) {
        cardService.deletedCard(id);

        return ResponseEntity.noContent().build();
    }

}
