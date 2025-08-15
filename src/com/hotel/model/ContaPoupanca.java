package com.hotel.model;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca() {
        super();
        this.taxaRendimento = 0.0;
    }

    public ContaPoupanca(String titular, String numero, double saldo, double taxaRendimento) {
        super(titular, numero, saldo);
        this.taxaRendimento = taxaRendimento;
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
