package com.banco.model;

public class Conta {

    //O sistema deverá permitir o cadastro de contas, depósitos, saques,
    //transferências e listagem das contas, exibindo informações detalhadas conforme o tipo de
    //conta.

    protected String titular;
    protected String numero;
    protected double saldo;

    public Conta() {
        this.titular = null;
        this.numero = null;
        this.saldo = 0;
    }

    public Conta(String titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
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

    public String toString(){
        return "Titular: " + titular + "\nNúmero da Conta: " + numero + "\nSaldo: " + saldo;
    }

}
