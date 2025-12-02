package com.banco.main;

import com.banco.dto.DadosRegistroCivil;
import com.banco.model.Conta;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.model.Titular;
import com.banco.service.Banco;
import com.banco.service.registrocivil.RegistroCivilUniversal;
import com.banco.service.registrocivil.RegistroEstrangeiroAdaptee;
import com.banco.service.registrocivil.RegistroEstrangeiroAdapter;
import com.banco.view.HandleError;
import com.banco.view.UserInterface;

import java.awt.print.Book;
import java.sql.SQLException;

public class Main {

    public static void abrirConta(RegistroCivilUniversal registroService, Titular titular, String identificador) {
        System.out.println("\n--- CLIENTE DO BANCO: Tentando abrir conta ---");

        // O cliente só conhece a interface RegistroCivilUniversal (o Target)
        DadosRegistroCivil dados = registroService.relacionaNacionalidade(titular, identificador);

        System.out.println("✅ CONTA ABERTA COM SUCESSO!");
        System.out.println("Dados Finais: Nacionalidade: " + dados.nacionalidade() + ", Registro Civil: " + dados.registroCivil());
    }

    public static void main(String[] args) throws SQLException {

        /*
        UserInterface userInterface = new UserInterface();
        Banco banco = new Banco();
        int keyMenu = -1;


        while (keyMenu!=0){
            keyMenu = userInterface.mainPage();
            banco.managerPage(keyMenu);
        }
        */

        Titular titularEstrangeiro = new Titular(101, "John Smith", "Britânico", "UK1234567"); // UK1234567 é o Passport ID
        RegistroEstrangeiroAdaptee adaptee = new RegistroEstrangeiroAdaptee();
        RegistroCivilUniversal adapter = new RegistroEstrangeiroAdapter(adaptee); // Instancia o Adapter

        abrirConta(adapter, titularEstrangeiro, "NaoRelevanteAqui");


    }
}