package com.banco.model;

public class ContaCorrente extends Conta{

    private Integer id;
    private double movimentacaoDiaria;

    public ContaCorrente(){ super(); this.movimentacaoDiaria = 0; }

    public ContaCorrente(String titular, String numero, double saldo, double movimentacaoDiaria){ super(titular, numero, saldo); this.movimentacaoDiaria = movimentacaoDiaria; }

    public ContaCorrente(Integer id, double movimentacaoDiaria) {
        this.movimentacaoDiaria = movimentacaoDiaria;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
