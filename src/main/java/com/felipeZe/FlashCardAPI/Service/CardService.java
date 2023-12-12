package com.felipeZe.FlashCardAPI.Service;

import com.felipeZe.FlashCardAPI.api.Model.Card;
import com.felipeZe.FlashCardAPI.api.Repository.CardRepository;
import com.felipeZe.FlashCardAPI.dtos.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;


    public Card findCardById(Long id) {
        return this.cardRepository.findCardById(id).get();
    }

    public List<Card> listAllCards() {
        return this.cardRepository.findAll();
    }

    public Card createCard(CardDTO card) {
        Card newCard = new Card(card);
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

        return this.cardRepository.save(card);

    }

    public void deletedCard(Long id) {
        cardRepository.deleteById(id);
    }
}
