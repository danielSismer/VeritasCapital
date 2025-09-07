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

            case 0 -> {
                uiView.shutdown();
            }

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
                if(contas.size() >= 2){
                    Conta senderAccount = searchNumberAccount(uiView.readConta("Conta remetente"));
                    Conta receiverAccount = searchNumberAccount(uiView.readConta("Conta Destinatária"));

                    if(senderAccount != null && receiverAccount != null){
                        double balanceSender = transfer(senderAccount, receiverAccount);

                        if(balanceSender == -1){
                            uiView.balanceAbove();
                        }
                    } else {
                        uiView.notFound();
                    }
                }
                else {
                    uiView.transferLessTwo();
                }
            }

            //listagem
            case 5 -> {
                if(contas.isEmpty()){
                    uiView.ListEmpty();
                }
                else {
                    for (Conta contaUnit : contas) {
                        System.out.println(contaUnit);
                    }
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
        double movimentacaoDiaria = uiView.readMovimentacao();

        return new ContaCorrente(titular, numeroConta, 0, movimentacaoDiaria);
    }

    private Conta formerContaPoupanca(Conta conta) {
        String titular = conta.getTitular();
        String numeroConta = conta.getNumero();
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

    private double transfer(Conta senderAccount, Conta receiverAccount){
        double balanceInputSender = uiView.readSaldo("Transferência", "transferir para a conta " + receiverAccount.getNumero());

        double balanceSender = senderAccount.getSaldo() - balanceInputSender;
        double balanceReceiver = receiverAccount.getSaldo() + balanceInputSender;


        if(balanceSender >= 0){
            senderAccount.setSaldo(balanceSender);
            receiverAccount.setSaldo(balanceReceiver);
            return balanceSender;
        }
        else {
            return -1;
        }

    }
}
