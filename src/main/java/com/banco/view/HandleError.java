package com.banco.view;

import java.util.Scanner;

public class HandleError {

    public static int validInt(Scanner input, String message, String validOption) {
        while (true) {

            System.out.println(validOption);
            String valor = input.nextLine();

            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                System.out.println(message);
            }
        }
    }

    public static double validDouble(Scanner input, String mensagem, String validOption){
        while (true) {
            System.out.println(validOption);
            String valor = input.nextLine();

            try {
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número decimal (ex: 10.5).");
                System.out.println(mensagem);
            }
        }
    }

}
