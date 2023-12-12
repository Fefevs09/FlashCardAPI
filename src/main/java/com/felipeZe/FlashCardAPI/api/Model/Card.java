package com.felipeZe.FlashCardAPI.api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String pergunta, resposta;
    private LocalDate revisao = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Feedback feedback;
    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Deck deck;

    public Card(CardDTO card) {
        this.resposta = card.reposta();
        this.pergunta = card.pergunta();
    }

    public LocalDate revisaoEspacada(Feedback feedback){

        if (revisao == null)
            revisao = LocalDate.now();

        switch(feedback){
            case HARD:
                revisao = revisao.plusDays(1);
                break;
            case GOOD:
                revisao = revisao.plusWeeks(1);
                break;
            case EASY:
                revisao = revisao.plusMonths(1);
        }
        return revisao;
    }
}
