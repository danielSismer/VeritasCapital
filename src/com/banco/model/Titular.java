package com.banco.model;

public class Titular {

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
