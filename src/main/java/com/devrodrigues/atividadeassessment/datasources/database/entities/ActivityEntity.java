package com.devrodrigues.atividadeassessment.datasources.database.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Entity(name = "Atividade")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long disciplinaId;
    private Instant prazo;
    private String enunciado;
    private String resposta;

    @OneToMany(mappedBy = "activity", fetch = FetchType.EAGER)
    private List<SubmitEntity> submissoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Instant getPrazo() {
        return prazo;
    }

    public void setPrazo(Instant prazo) {
        this.prazo = prazo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public List<SubmitEntity> getSubmissoes() {
        return submissoes;
    }

    public void setSubmissoes(List<SubmitEntity> submissoes) {
        this.submissoes = submissoes;
    }
}
