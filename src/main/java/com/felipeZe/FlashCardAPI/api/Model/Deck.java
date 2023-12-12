package com.felipeZe.FlashCardAPI.api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private String titulo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Users user;
    @OneToMany(mappedBy = "deck", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Card> cards;

}
