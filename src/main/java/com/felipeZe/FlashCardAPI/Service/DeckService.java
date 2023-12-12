package com.felipeZe.FlashCardAPI.Service;

import com.felipeZe.FlashCardAPI.api.Model.Deck;
import com.felipeZe.FlashCardAPI.api.Model.Users;
import com.felipeZe.FlashCardAPI.api.Repository.DeckRepository;
import com.felipeZe.FlashCardAPI.dtos.DeckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private UserService userService;


    public Deck createDeck(DeckDTO deckRequest) throws Exception {
        Users user = this.userService.findUserById(deckRequest.userID());

        Deck newDeck = new Deck();
        newDeck.setTitulo(deckRequest.titulo());
        newDeck.setUser(user);

        this.deckRepository.save(newDeck);

        return newDeck;
    }

    public List<Deck> listAllDecks() {
        return this.deckRepository.findAll();
    }

    public List<Deck> listDecksByUser(Long userId) {
        return this.deckRepository.findByUserId(userId);
    }

    public Deck findDeckById(Long id) {
        return this.deckRepository.findDeckById(id).get();
    }

    public Deck updateDeck(Long id, DeckDTO deck) {
        Deck newDeck = this.findDeckById(id);

        newDeck.setTitulo(deck.titulo());
        this.deckRepository.save(newDeck);
        return newDeck;
    }

    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

}
