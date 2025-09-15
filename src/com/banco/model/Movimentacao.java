package com.banco.model;

import java.time.LocalDateTime;

public class Movimentacao {

    Integer id;
    Titular titular_remetente;
    Titular titular_destinario;
    String movimentacaoType;
    LocalDateTime data_horario;

    public Movimentacao(Integer id, Titular titular_remetente, Titular titular_destinario, String movimentacaoType, LocalDateTime data_horario) {
        this.id = id;
        this.titular_remetente = titular_remetente;
        this.titular_destinario = titular_destinario;
        this.movimentacaoType = movimentacaoType;
        this.data_horario = data_horario;
    }

    public Movimentacao(Titular titular_remetente, Titular titular_destinario, String movimentacaoType, LocalDateTime data_horario) {
        this.titular_remetente = titular_remetente;
        this.titular_destinario = titular_destinario;
        this.movimentacaoType = movimentacaoType;
        this.data_horario = data_horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Titular getTitular_remetente() {
        return titular_remetente;
    }

    public void setTitular_remetente(Titular titular_remetente) {
        this.titular_remetente = titular_remetente;
    }

    public Titular getTitular_destinario() {
        return titular_destinario;
    }

    public void setTitular_destinario(Titular titular_destinario) {
        this.titular_destinario = titular_destinario;
    }

    public String getMovimentacaoType() {
        return movimentacaoType;
    }

    public void setMovimentacaoType(String movimentacaoType) {
        this.movimentacaoType = movimentacaoType;
    }

    public LocalDateTime getData_horario() {
        return data_horario;
    }

    public void setData_horario(LocalDateTime data_horario) {
        this.data_horario = data_horario;
    }
}
