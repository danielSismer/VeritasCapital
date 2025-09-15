package com.banco.service;

import com.banco.dao.ContaDao;
import com.banco.dao.TitularDao;
import com.banco.model.*;
import com.banco.view.UserInterface;

import java.util.ArrayList;

public class Banco {

    ArrayList<Titular> titulares;
    ArrayList<Conta> contas;
    ArrayList<Movimentacao> movimentacoes;

    UserInterface uiView;

    TitularDao titularData;
    ContaDao contaData;


    public Banco(){
        contas = new ArrayList<>();
        uiView = new UserInterface();
        titularData = new TitularDao();
        contaData = new ContaDao();
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

            case 1 ->{

                String nome = uiView.readTitular("Cadastrar titular", "nome");;
                String cpf = uiView.readTitular("Cadastrar titular", "CPF/CNPJ");
                titularData.insert(nome, cpf);
            }

            case 2 -> {
                Integer titular_id = uiView.readId("Registrar Conta", "ID");
                String numeroConta = uiView.readConta("Registrar Conta");
                int keyType = uiView.typePage();
                ContaType contaEnum = managerType(keyType);
                String contaTypeString = contaEnum.toString();

                Titular titular = listTitular(titular_id);

                contaData.insert(titular, numeroConta, 0, contaTypeString);
            }

            //depósito
            case 3 -> {
                Conta conta = searchNumberAccount(uiView.readConta("Depósito"));

                if(conta != null){
                    conta.setSaldo(uiView.readSaldo("Depósito", "depositar"));
                } else {
                    uiView.notFound();
                }

            }
            //saque
            case 4 -> {
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
            case 5 -> {
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
            case 6 -> {
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


    private ContaType managerType(int keyType) {
        switch (keyType) {

            case 1 -> {
                return ContaType.CONTA_CORRENTE;
            }
            case 2 -> {
                return ContaType.CONTA_POUPANCA;
            }
            default -> {
                uiView.errorDefault();
                return null;
            }
        }
    }

    private Titular listTitular(Integer id){
        for(Titular titular: titulares){
            if(titular.getId() == id){
                return titular;
            }
        }

        return null;
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
