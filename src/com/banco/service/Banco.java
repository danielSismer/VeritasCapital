package com.banco.service;

import com.banco.model.Conta;
import com.banco.model.ContaCorrente;
import com.banco.model.ContaPoupanca;
import com.banco.view.UserInterface;

import java.util.ArrayList;

public class Banco {

    ArrayList<Conta> contas;
    UserInterface uiView;

    public Banco(){
        contas = new ArrayList<>();
        uiView = new UserInterface();
    }

    //depositar = ganho de saldo
    //sacar = perda de saldo
    //transferir = perda de saldo e ganho de outro
    //listar = usar instanceof

    // depositar ->
    // sacar ->

    public void managerPage(int keyPage, ContaPoupanca contaPoupanca, ContaCorrente contaCorrente) {
        switch (keyPage) {

            case 1 -> {
                Conta conta = formerConta();
                int keyType = uiView.typePage();
                managerType(keyType, conta);
            }

            //depósito
            case 2 -> {
                Conta conta = searchNumberAccount(uiView.readConta("Depósito"));

                if(conta != null){
                    conta.setSaldo(uiView.readSaldo("Depósito", "depositar"));
                } else {
                    uiView.notFound();
                }

            }
            //saque
            case 3 -> {
                Conta conta = searchNumberAccount(uiView.readConta("Saque"));

                if(conta != null){
                    double balanceAccount = withdrawal(conta);

                    if (balanceAccount == -1){
                        uiView.balanceAbove();
                    }

                } else {
                    uiView.notFound();
                }

            }

            //transferência
            case 4 -> {
            }

            //listagem
            case 5 -> {
                for (Conta contaUnit : contas) {
                    System.out.println(contaUnit);
                }
            }


            default -> {
                uiView.errorDefault();
            }
        }
    }

    //Toda conta criada tem valor 0 de saldo

    private Conta formerConta() {
        String titular = uiView.readTitular("Registrar");
        String numeroConta = uiView.readConta("Registrar");

        return new Conta(titular, numeroConta, 0);
    }

    private void managerType(int keyType, Conta conta) {
        switch (keyType) {

            case 1 -> {
                Conta objectChoose = formerContaCorrente(conta);
                contas.add(objectChoose);
            }
            case 2 -> {
                Conta objectChoose = formerContaPoupanca(conta);
                contas.add(objectChoose);
            }
            default -> {
                uiView.errorDefault();
            }
        }
    }

    private Conta formerContaCorrente(Conta conta) {
        String titular = conta.getTitular();
        String numeroConta = conta.getNumero();
        double saldo = conta.getSaldo();
        double movimentacaoDiaria = uiView.readMovimentacao();

        return new ContaCorrente(titular, numeroConta, 0, movimentacaoDiaria);
    }

    private Conta formerContaPoupanca(Conta conta) {
        String titular = conta.getTitular();
        String numeroConta = conta.getNumero();
        double saldo = conta.getSaldo();
        double taxaRendimento = uiView.readRendimento();

        return new ContaPoupanca(titular, numeroConta, 0, taxaRendimento);
    }

    private Conta searchNumberAccount(String numberAccount) {
        for (Conta contaUnit : contas) {
            if (contaUnit.getNumero().equalsIgnoreCase(numberAccount)) {
                return contaUnit;
            }
        }
        return null;
    }

    private double withdrawal(Conta conta){
        double balanceInput = uiView.readSaldo("Saque", "sacar");
        double balanceAccount = conta.getSaldo() - balanceInput;

        if (balanceAccount >= 0){
            conta.setSaldo(balanceAccount);
            return conta.getSaldo();
        }
        return -1;

    }

}
