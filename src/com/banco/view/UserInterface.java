package com.banco.view;

import java.util.Scanner;

public class UserInterface {

    private static Scanner input;

    public UserInterface() {
        input = new Scanner(System.in);
    }

    public int mainPage() {
        System.out.println("===========================================================================");
        System.out.println("|                          Veritas Capital                                |");
        System.out.println("=========================================================================== ");
        System.out.println("|  1 - Depositar                                                          |");
        System.out.println("|  2 - Sacar                                                              |");
        System.out.println("|  3 - Transferir                                                         |");
        System.out.println("|  4 - Listar contas                                                      |");
        System.out.println("|                                                                          |");
        System.out.println("|                                                           0 - Sair       |");
        System.out.println("=========================================================================== ");

        return HandleError.validInt(input, , "Tente novamente", "Digite uma opção: ");
    }


    public int deposit() {
        System.out.println("============================================================================");
        System.out.println("|                              Depositar                                   |");
        System.out.println("=========================================================================== ");
        System.out.println("|                                                                          |");
        System.out.println("| Por favor, insira o número da sua conta:                                 |");
        System.out.println("|                                                                          |");
        System.out.println("============================================================================");

        return HandleError.validInt(input, "Tente novamente: ", "Digite uma opção: ");
    }


}
