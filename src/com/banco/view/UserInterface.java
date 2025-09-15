package com.banco.view;

import com.banco.model.Conta;

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
        System.out.println("|  1 - Registrar titular                                                  |");
        System.out.println("|  2 - Registrar conta                                                    |");
        System.out.println("|  3 - Depositar                                                          |");
        System.out.println("|  4 - Sacar                                                              |");
        System.out.println("|  5 - Transferir                                                         |");
        System.out.println("|  6 - Listar contas                                                      |");
        System.out.println("|                                                                         |");
        System.out.println("|                                                           0 - Sair      |");
        System.out.println("===========================================================================");

        return HandleError.validInt(input, "Tente novamente", "Digite uma opção: ");
    }

    public Integer readId(String operationType, String entidade){
        System.out.println("============================================================================");
        System.out.println("|                              "+ operationType +"                                  |");
        System.out.println("============================================================================");
        System.out.println("|                                                                          |");
        System.out.printf("| Por favor, insira o ID d%s:                              |\n", entidade);
        System.out.println("|                                                                          |");
        System.out.println("============================================================================");

        Integer id = input.nextInt();
        input.nextLine();


        return id;
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

    public String readTitular(String operationType, String entidade){
        System.out.println("============================================================================");
        System.out.println("|                              "+ operationType +"                                  |");
        System.out.println("============================================================================");
        System.out.println("|                                                                          |");
        System.out.printf("| Por favor, insira o %s do titular da conta:                              |", entidade);
        System.out.println("|                                                                          |");
        System.out.println("============================================================================");

        return input.nextLine();
    }

    public double readSaldo(String operationType, String commandType){
        System.out.println("============================================================================");
        System.out.println("|                              "+ operationType +"                                  |");
        System.out.println("============================================================================");
        System.out.println("|                                                                          |");
        System.out.println("| Por favor, insira o número de saldo que queira                           |");
        System.out.println("| "+ commandType + ":                                             |");
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
        System.out.println("|                                                                         |");
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

    public void confirmInsert(String entidade){

        System.out.println("===========================================================================");
        System.out.println("|                              Registrar                                  |");
        System.out.println("===========================================================================");
        System.out.println("|                                                                         |");
        System.out.printf("|   %s registrada com sucesso!                      |", entidade);
        System.out.println("|                                                                         |");
        System.out.println("===========================================================================");

    }

    public void shutdown(){
        System.out.println("===========================================================================");
        System.out.println("|                             Encerramento                                 |");
        System.out.println("===========================================================================");
        System.out.println("|                                                                         |");
        System.out.println("| Programa encerrando....                                                 |");
        System.out.println("|                                                                         |");
        System.out.println("===========================================================================");
    }

    public void errorDefault(){
        System.err.println("===========================================================================");
        System.err.println("|                                 Erro                                    |");
        System.err.println("===========================================================================");
        System.err.println("|                                                                         |");
        System.err.println("| Por favor, insira um número correspondente com a legenda                |");
        System.err.println("|                                                                         |");
        System.err.println("===========================================================================");
    }

    public void notFound(){
        System.err.println("===========================================================================");
        System.err.println("|                                 Erro                                    |");
        System.err.println("===========================================================================");
        System.err.println("|                                                                         |");
        System.err.println("| Por favor, insira uma conta que exista no sistema                       |");
        System.err.println("|                                                                         |");
        System.err.println("===========================================================================");
    }

    public void balanceAbove(){
        System.err.println("===========================================================================");
        System.err.println("|                                 Erro                                    |");
        System.err.println("===========================================================================");
        System.err.println("|                                                                         |");
        System.err.println("|  O valor retirado é maior do que já tem de saldo.                       |");
        System.err.println("|                                                                         |");
        System.err.println("===========================================================================");
    }

    public void transferLessTwo(){
        System.err.println("===========================================================================");
        System.err.println("|                                 Erro                                    |");
        System.err.println("===========================================================================");
        System.err.println("|                                                                         |");
        System.err.println("|  É necessário haver duas contas para conseguir realizar transferência.  |");
        System.err.println("|                                                                         |");
        System.err.println("===========================================================================");
    }

    public void ListEmpty(){
        System.err.println("===========================================================================");
        System.err.println("|                                 Erro                                    |");
        System.err.println("===========================================================================");
        System.err.println("|                                                                         |");
        System.err.println("|  Não há nenhuma conta registrada no momento.                            |");
        System.err.println("|                                                                         |");
        System.err.println("===========================================================================");
    }

    public void errorDatabase(){
        System.err.println("===========================================================================");
        System.err.println("|                                 Erro                                    |");
        System.err.println("===========================================================================");
        System.err.println("|                                                                         |");
        System.err.println("|  Não foi possível comunicar com o banco de dados do Veritas Capital,    |");
        System.err.println("|  tente novamente outra hora.                                            |");
        System.err.println("|                                                                         |");
        System.err.println("===========================================================================");
    }

    public void listAccount(Conta conta, int cont){
        System.out.println(cont + "- " + conta);
    }


}
