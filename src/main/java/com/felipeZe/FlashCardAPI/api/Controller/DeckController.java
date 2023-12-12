package com.felipeZe.FlashCardAPI.api.Controller;

import com.felipeZe.FlashCardAPI.Service.DeckService;
import com.felipeZe.FlashCardAPI.api.Model.Deck;
import com.felipeZe.FlashCardAPI.dtos.DeckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping
    public ResponseEntity<List<Deck>> getAllDecks() {
        List<Deck> decks = deckService.listAllDecks();

        return new ResponseEntity<>(decks, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Deck>> listDecksByUserId(@PathVariable Long userId) {
        List<Deck> decks = deckService.listDecksByUser(userId);

        return new ResponseEntity<>(decks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> getUser(@PathVariable Long id) {
        Deck deck = deckService.findDeckById(id);
        if (deck != null) {
            return new ResponseEntity<>(deck, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Deck> createDeck(@RequestBody DeckDTO createDeck) throws Exception {
        Deck deck = deckService.createDeck(createDeck);

        return new ResponseEntity<>(deck, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deck> updateDeck(@PathVariable Long id, @RequestBody DeckDTO updateDeck) {
        Deck deck = this.deckService.updateDeck(id, updateDeck);

        return new ResponseEntity<>(deck, HttpStatus.OK);
    }

    @DeleteMapping("/deck/{id}")
    public ResponseEntity<Deck> deleteDeck(@PathVariable Long id) {
        deckService.deleteDeck(id);

        return ResponseEntity.noContent().build();
    }
}
