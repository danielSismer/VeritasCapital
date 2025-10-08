package com.veritasCapital.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContaCorrente extends Conta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Conta conta;
    private double movimentacaoDiaria;

    public ContaCorrente(){ super(); this.movimentacaoDiaria = 0; }

    public ContaCorrente(Titular titular, String numero, double saldo, double movimentacaoDiaria){ super(titular, numero, saldo); this.movimentacaoDiaria = movimentacaoDiaria; }

    public ContaCorrente(Integer id, double movimentacaoDiaria) {
        super(id);
        this.movimentacaoDiaria = movimentacaoDiaria;
    }

    public ContaCorrente(double movimentacaoDiaria) {
        this.movimentacaoDiaria = movimentacaoDiaria;
    }

    @Override
    public String toString(){
        return super.toString() + "\nMovimentação Diária: " + movimentacaoDiaria;
    }

    public double getMovimentacaoDiaria() {
        return movimentacaoDiaria;
    }

    public void setMovimentacaoDiaria(double movimentacaoDiaria) {
        this.movimentacaoDiaria = movimentacaoDiaria;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}