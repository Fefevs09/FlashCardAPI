package com.felipeZe.FlashCardAPI.entities.deck;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipeZe.FlashCardAPI.entities.card.Card;
import com.felipeZe.FlashCardAPI.entities.user.Users;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Entity(name = "deck")
@Table(name = "deck")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String title;
    private LocalDateTime dateCreate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;
    @OneToMany(mappedBy = "deck", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Card> cards;

}
