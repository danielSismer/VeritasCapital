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
                boolean found = searchNumberAccount(uiView.readConta("Depósito"));

                if (found) {
                    System.out.print("objeto encontrado");
                } else {
                    System.out.print("objeto não encontrado");
                }

            }
            //sacada
            case 3 -> {
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

    private boolean searchNumberAccount(String numberAccount) {
        boolean found = false;
        for (Conta contaUnit : contas) {
            if (contaUnit.getNumero().equalsIgnoreCase(numberAccount)) {
                found = true;
            }
        }
        return found;
    }

}
