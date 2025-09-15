package com.banco.model;

public class ContaPoupanca extends Conta {

    private Integer id;
    private double taxaRendimento;

    public ContaPoupanca() {
        super();
        this.taxaRendimento = 0.0;
    }

    public ContaPoupanca(String titular, String numero, double saldo, double taxaRendimento) {
        super(titular, numero, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(Integer id, double taxaRendimento) {
        this.id = id;
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
