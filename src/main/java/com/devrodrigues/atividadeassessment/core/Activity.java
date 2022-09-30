package com.devrodrigues.atividadeassessment.core;

import java.time.Instant;
import java.util.List;

public class Activity {

    private final Long id;
    private final Long disciplinaId;
    private final Instant prazo;
    private final String enunciado;
    private final String resposta;

    private List<Submit> submissoes;

    public Activity(Long id,
                    Long disciplinaId,
                    Instant prazo,
                    String enunciado,
                    String resposta) {
        this.id = id;
        this.disciplinaId = disciplinaId;
        this.prazo = prazo;
        this.enunciado = enunciado;
        this.resposta = resposta;
    }

    public Long getId() {
        return id;
    }
    public Long getDisciplinaId() {
        return disciplinaId;
    }
    public Instant getPrazo() {
        return prazo;
    }
    public String getEnunciado() {
        return enunciado;
    }
    public String getResposta() {
        return resposta;
    }

    public List<Submit> getSubmissoes() {
        return submissoes;
    }

    public void setSubmissoes(List<Submit> submissoes) {
        this.submissoes = submissoes;
    }
}
