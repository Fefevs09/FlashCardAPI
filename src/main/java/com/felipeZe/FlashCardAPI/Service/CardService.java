package com.felipeZe.FlashCardAPI.Service;

import com.felipeZe.FlashCardAPI.api.Model.Card;
import com.felipeZe.FlashCardAPI.api.Model.Deck;
import com.felipeZe.FlashCardAPI.api.Model.Feedback;
import com.felipeZe.FlashCardAPI.api.Repository.CardRepository;
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
        newCard.setPergunta(card.pergunta());
        newCard.setResposta(card.reposta());
        newCard.setFeedback(Feedback.NONE);
        newCard.setRevisao(LocalDate.now());
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
        card.setPergunta(uptadedCard.pergunta());
        card.setResposta(uptadedCard.reposta());
        card.setFeedback(uptadedCard.feedback());
        card.setRevisao(card.revisaoEspacada());

        return this.cardRepository.save(card);
    }

    public void deletedCard(Long id) {
        cardRepository.deleteById(id);
    }
}
