package com.banco.main;

import com.banco.model.Conta;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.service.Banco;
import com.banco.view.HandleError;
import com.banco.view.UserInterface;

import java.awt.print.Book;

public class Main {
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        Banco banco = new Banco();
        int keyMenu = -1;


        while (keyMenu!=0){
            keyMenu = userInterface.mainPage();
            banco.managerPage(keyMenu);
        }
    }
}