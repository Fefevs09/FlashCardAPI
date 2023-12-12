package com.felipeZe.FlashCardAPI.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipeZe.FlashCardAPI.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Deck> deck;

    public Users(UserDTO user) {
        this.nome = user.nome();
        this.email = user.email();
        this.senha = user.senha();
    }
}
