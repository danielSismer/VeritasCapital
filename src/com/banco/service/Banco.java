package com.banco.service;

import com.banco.model.Conta;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.view.UserInterface;

import java.util.ArrayList;

public class Banco {

    ArrayList<Conta> contas;

    public Banco(){
        contas = new ArrayList<Conta>();
    }

    //depositar = ganho de saldo
    //sacar = perda de saldo
    //transferir = perda de saldo e ganho de outro
    //listar = usar instanceof

    // depositar ->
    // sacar ->

    public void managerPage(int keyPage, UserInterface userInterface, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente){
        switch (keyPage){

            case 1 ->{
                userInterface.deposit();
            }

            case 2 ->{}

            case 3 ->{}

            case 4 ->{}



            default ->{}
        }
    }



}
