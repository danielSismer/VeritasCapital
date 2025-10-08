package com.veritasCapital.bank.model;

import jakarta.persistence.Embeddable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Embeddable
public class Titular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    String cpf;

    public Titular(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Titular(Integer id, String nome, String cpf){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Titular(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Titular(Integer id){
        this.id = id;
    }

    public Titular() {
        this.nome = null;
        this.cpf = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString(){
        return "=========================| Titular |=========================\n" +
                "ID: " + this.id +
                "\nTitular: " + this.nome +
                "\nNúmero: " + this.cpf + "\n";
    }
}