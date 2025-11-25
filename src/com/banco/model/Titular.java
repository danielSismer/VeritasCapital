package com.banco.model;

public class Titular {

    Integer id;
    String nome;
    String nacionalidade;
    String registroCivil;

    public Titular(Integer id, String nome, String nacionalidade, String registroCivil) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.registroCivil = registroCivil;
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRegistroCivil() {
        return registroCivil;
    }

    public void setRegistroCivil(String registroCivil) {
        this.registroCivil = registroCivil;
    }

}
