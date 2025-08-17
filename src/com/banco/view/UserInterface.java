package com.banco.view;

import java.util.Scanner;

public class UserInterface {

    private static Scanner input;

    public UserInterface() {
        input = new Scanner(System.in);
    }

    //Daniel, adicionei registrar conta, pois todo depósito e essas outras opções presumem que existe uma conta

    public int mainPage() {
        System.out.println("===========================================================================");
        System.out.println("|                          Veritas Capital                                |");
        System.out.println("===========================================================================");
        System.out.println("|  1 - Registrar conta                                                    |");
        System.out.println("|  2 - Depositar                                                          |");
        System.out.println("|  3 - Sacar                                                              |");
        System.out.println("|  4 - Transferir                                                         |");
        System.out.println("|  5 - Listar contas                                                      |");
        System.out.println("|                                                                         |");
        System.out.println("|                                                           0 - Sair      |");
        System.out.println("===========================================================================");

        return HandleError.validInt(input, "Tente novamente", "Digite uma opção: ");
    }


    public String readConta(String operationType) {

        System.out.println("============================================================================");
        System.out.println("|                              "+ operationType +"                                  |");
        System.out.println("============================================================================");
        System.out.println("|                                                                          |");
        System.out.println("| Por favor, insira o número da sua conta:                                 |");
        System.out.println("|                                                                          |");
        System.out.println("============================================================================");

        return input.nextLine();
    }

    public String readTitular(String operationType){
        System.out.println("============================================================================");
        System.out.println("|                              "+ operationType +"                                  |");
        System.out.println("============================================================================");
        System.out.println("|                                                                          |");
        System.out.println("| Por favor, insira o titular da conta:                                    |");
        System.out.println("|                                                                          |");
        System.out.println("============================================================================");

        return input.nextLine();
    }

    public double readSaldo(String operationType){
        System.out.println("============================================================================");
        System.out.println("|                                  Depósito                                |");
        System.out.println("============================================================================");
        System.out.println("|                                                                          |");
        System.out.println("| Por favor, insira o número de saldo que queira depositar:                |");
        System.out.println("|                                                                          |");
        System.out.println("============================================================================");

        return HandleError.validDouble(input, "Tente novamente", "Digite um número correspondente: ");
    }

    public int typePage(){
        System.out.println("===========================================================================");
        System.out.println("|                            Tipo de conta                                |");
        System.out.println("===========================================================================");
        System.out.println("|  1 - Conta Corrente                                                     |");
        System.out.println("|  2 - Conta Poupança                                                     |");
        System.out.println("|                                                                         |");
        System.out.println("|                                                           0 - Sair      |");
        System.out.println("===========================================================================");

        return HandleError.validInt(input, "Tente novamente", "Digite uma opção: ");
    }

    public double readMovimentacao(){
        System.out.println("===========================================================================");
        System.out.println("|                              Registrar                                  |");
        System.out.println("===========================================================================");
        System.out.println("|                                                                         |");
        System.out.println("| Por favor, insira o número de saldo de movimentação da conta:           |");
        System.out.println("|                                                                         |");
        System.out.println("===========================================================================");

        return HandleError.validDouble(input, "Tente novamente", "Digite um número correspondente: ");

    }

    public double readRendimento(){

        System.out.println("===========================================================================");
        System.out.println("|                              Registrar                                  |");
        System.out.println("===========================================================================");
        System.out.println("|                                                                         |");
        System.out.println("| Por favor, insira o número da taxa de rendimento:                       |");
        System.out.println("|                                                                         |");
        System.out.println("===========================================================================");

        return HandleError.validDouble(input, "Tente novamente", "Digite um número correspondente: ");
    }

    public void errorDefault(){
        System.out.println("===========================================================================");
        System.out.println("|                                 Erro                                    |");
        System.out.println("===========================================================================");
        System.out.println("|                                                                         |");
        System.out.println("| Por favor, insira um número correspondente com a legenda                |");
        System.out.println("|                                                                         |");
        System.out.println("===========================================================================");
    }


}
