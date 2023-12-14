package com.felipeZe.FlashCardAPI.services;

import com.felipeZe.FlashCardAPI.entities.deck.Deck;
import com.felipeZe.FlashCardAPI.entities.user.Users;
import com.felipeZe.FlashCardAPI.repositorys.DeckRepository;
import com.felipeZe.FlashCardAPI.dtos.DeckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private UserService userService;


    public Deck createDeck(DeckDTO deckRequest) throws Exception {
        Users user = this.userService.findUserById(deckRequest.userID());

        Deck newDeck = new Deck();
        newDeck.setTitle(deckRequest.title());
        newDeck.setUser(user);
        newDeck.setDateCreate(LocalDateTime.now());

        List<Deck> userDecks = user.getDeck();
        userDecks.add(newDeck);
        user.setDeck(userDecks);

        this.deckRepository.save(newDeck);

        return newDeck;
    }

    public List<Deck> listAllDecks() {
        return this.deckRepository.findAll();
    }

    public List<Deck> listDecksByUser(String userId) {
        return this.deckRepository.findByUserId(userId);
    }

    public Deck findDeckById(Long id) {
        return this.deckRepository.findDeckById(id).get();
    }

    public Deck updateDeck(Long id, DeckDTO newDeck) {
        Deck deck = this.findDeckById(id);

        deck.setTitle(newDeck.title());

        this.deckRepository.save(deck);

        return deck;
    }

    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

}
