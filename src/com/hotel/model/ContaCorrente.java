package com.hotel.model;

public class ContaCorrente extends Conta{

    private double movimentacaoDiaria;

    public ContaCorrente(){ super(); this.movimentacaoDiaria = 0; }

    public ContaCorrente(String titular, String numero, double saldo, double movimentacaoDiaria){ super(titular, numero, saldo); this.movimentacaoDiaria = movimentacaoDiaria; }

    @Override
    public String toString(){
        return super.toString() + "\nMovimentação Diária: " + movimentacaoDiaria;
    }

}
