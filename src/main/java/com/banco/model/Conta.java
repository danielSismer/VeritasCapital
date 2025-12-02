package com.banco.model;

public class Conta {

    //O sistema deverá permitir o cadastro de contas, depósitos, saques,
    //transferências e listagem das contas, exibindo informações detalhadas conforme o tipo de
    //conta.

    private Integer id;
    protected Titular titular;
    protected String numero;
    protected double saldo;
    private String contaType;

    public Conta() {
        this.titular = null;
        this.numero = null;
        this.saldo = 0;
    }

    public Conta(Titular titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(Titular titular, String numero, double saldo, String contaType) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
        this.contaType = contaType;
    }

    public Conta(Integer id, Titular titular, String numero, double saldo, String contaType) {
        this.id = id;
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
        this.contaType = contaType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getContaType() {
        return contaType;
    }

    public void setContaType(String contaType) {
        this.contaType = contaType;
    }

    public String toString(){
        return "=========================| Conta |=========================\n" +
                "ID: " + this.id +
                "\nTitular: " + this.titular.getNome() +
                "\nNúmero: " + this.numero +
                "\nSaldo: " + this.saldo +
                "\nTipo de conta: " + this.contaType + "\n";
    }

}
