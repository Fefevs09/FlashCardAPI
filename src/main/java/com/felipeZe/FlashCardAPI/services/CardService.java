package com.felipeZe.FlashCardAPI.services;

import com.felipeZe.FlashCardAPI.entities.card.Card;
import com.felipeZe.FlashCardAPI.entities.deck.Deck;
import com.felipeZe.FlashCardAPI.entities.card.Feedback;
import com.felipeZe.FlashCardAPI.repositorys.CardRepository;
import com.felipeZe.FlashCardAPI.dtos.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DeckService deckService;


    public Card findCardById(Long id) {
        return this.cardRepository.findCardById(id).get();
    }

    public List<Card> listAllCards() {
        return this.cardRepository.findAll();
    }

    public Card createCard(CardDTO card) {
        Deck deck = this.deckService.findDeckById(card.deckId());

        Card newCard = new Card();
        newCard.setQuestion(card.pergunta());
        newCard.setAnswer(card.reposta());
        newCard.setFeedback(Feedback.NONE);
        newCard.setReview(LocalDate.now());
        newCard.setDeck(deck);

        List<Card> cards = deck.getCards();
        cards.add(newCard);
        deck.setCards(cards);

        this.cardRepository.save(newCard);

         return newCard;
    }

    public List<Card> listCardsByDeck(Long id) {
        return this.cardRepository.findByDeckId(id);
    }

    public Card updateCard(Long id, CardDTO uptadedCard) {

        Card card = this.findCardById(id);
        card.setQuestion(uptadedCard.pergunta());
        card.setAnswer(uptadedCard.reposta());
        card.setFeedback(uptadedCard.feedback());
        card.setReview(card.revisaoEspacada());

        return this.cardRepository.save(card);
    }

    public void deletedCard(Long id) {
        cardRepository.deleteById(id);
    }
}
