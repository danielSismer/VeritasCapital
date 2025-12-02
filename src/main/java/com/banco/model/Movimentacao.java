package com.banco.model;

import java.time.LocalDateTime;

public class Movimentacao {

    Integer id;
    Conta conta_remetente;
    Conta conta_destinario;
    String movimentacaoType;
    double valor;
    LocalDateTime data_horario;

    public Movimentacao(Integer id, Conta conta_remetente, Conta conta_destinario, String movimentacaoType, double valor, LocalDateTime data_horario) {
        this.id = id;
        this.conta_remetente = conta_remetente;
        this.conta_destinario = conta_destinario;
        this.movimentacaoType = movimentacaoType;
        this.valor = valor;
        this.data_horario = data_horario;
    }

    public Movimentacao(Conta conta_remetente, Conta conta_destinario, String movimentacaoType, double valor, LocalDateTime data_horario) {
        this.conta_remetente = conta_remetente;
        this.conta_destinario = conta_destinario;
        this.movimentacaoType = movimentacaoType;
        this.valor = valor;
        this.data_horario = data_horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conta getConta_remetente() {
        return conta_remetente;
    }

    public void setConta_remetente(Conta conta_remetente) {
        this.conta_remetente = conta_remetente;
    }

    public Conta getConta_destinario() {
        return conta_destinario;
    }

    public void setConta_destinario(Conta conta_destinario) {
        this.conta_destinario = conta_destinario;
    }

    public String getMovimentacaoType() {
        return movimentacaoType;
    }

    public void setMovimentacaoType(String movimentacaoType) {
        this.movimentacaoType = movimentacaoType;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_horario() {
        return data_horario;
    }

    public void setData_horario(LocalDateTime data_horario) {
        this.data_horario = data_horario;
    }
}
