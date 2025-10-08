package com.veritasCapital.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContaPoupanca extends Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Conta conta;
    private double taxaRendimento;

    public ContaPoupanca() {
        super();
        this.taxaRendimento = 0.0;
    }

    public ContaPoupanca(Titular titular, String numero, double saldo, double taxaRendimento) {
        super(titular, numero, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(Integer id, double taxaRendimento) {
        super(id);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Taxa de Rendimento: " + taxaRendimento;
    }

}