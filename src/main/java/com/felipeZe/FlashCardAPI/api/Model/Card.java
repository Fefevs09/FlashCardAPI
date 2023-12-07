package com.felipeZe.FlashCardAPI.api.Model;

import java.time.LocalDate;

public class Card {
    private int id;
    private String pergunta, resposta;
    private int numVezesRespon;
    private LocalDate revisao;
    private Feedback feedback;

    public Card(int id, String pergunta, String resposta) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.numVezesRespon = 0;
        this.revisao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public int getNumVezesRespon() {
        return numVezesRespon;
    }

    public LocalDate getRevisao() {
        return revisao;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public LocalDate revisaoEspacada(Feedback feedback){

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
