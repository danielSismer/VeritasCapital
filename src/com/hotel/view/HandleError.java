package com.hotel.view;

import java.util.Scanner;
public class HandleError {

    public static void validInt(String mensagem){

        Scanner input = new Scanner(System.in);
        boolean validated = false;

        while(validated){
            System.out.println(mensagem);
            String valor = input.nextLine();

            int opcao = Integer.parseInt(valor);

        }
    }
}
