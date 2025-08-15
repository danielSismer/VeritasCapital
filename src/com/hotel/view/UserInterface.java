package com.hotel.view;

import java.util.Scanner;

public class UserInterface {

    private static Scanner input;

    public UserInterface(){
        input = new Scanner(System.in);
    }

    public int mainPage(){
        System.out.println("----------------------------| Veritas Capital |----------------------------");
        System.out.println("| 1 - Depositar                                                           |");
        System.out.println("| 2 - Sacar                                                               |");
        System.out.println("| 3 - Transferir                                                          |");
        System.out.println("| 4 - Listar                                                              |");
        System.out.println("|                                                                         |");
        System.out.println("|                                                               0 - Sair  |");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("\nDigite um número correspondente com a legenda: >");

        return input.nextInt();
    }

}
