package com.felipeZe.FlashCardAPI.entities.card;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.felipeZe.FlashCardAPI.entities.deck.Deck;
import com.felipeZe.FlashCardAPI.dtos.CardDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question, answer;
    private LocalDate review = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Feedback feedback;
    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Deck deck;

    public Card(CardDTO card) {
        this.answer = card.reposta();
        this.question = card.pergunta();
    }

    public LocalDate revisaoEspacada(){

        switch(this.feedback){
            case HARD, NONE:
                this.review = review.plusDays(1);
                break;
            case GOOD:
                this.review = review.plusWeeks(1);
                break;
            case EASY:
                this.review = review.plusMonths(1);
                break;
            default:
                this.review = LocalDate.now();
                break;
        }
        return this.review;
    }
}
