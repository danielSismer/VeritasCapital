package com.banco.service;

import com.banco.dao.ContaDao;
import com.banco.dao.MovimentacaoDao;
import com.banco.dao.TitularDao;
import com.banco.model.*;
import com.banco.view.UserInterface;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco {

    List<Titular> titulares;
    List<Conta> contas;
    List<Movimentacao> movimentacoes;

    UserInterface uiView;

    TitularDao titularData;
    ContaDao contaData;
    MovimentacaoDao movimentacaoData;


    public Banco(){
        contas = new ArrayList<>();
        uiView = new UserInterface();
        titularData = new TitularDao();
        contaData = new ContaDao();
        movimentacaoData = new MovimentacaoDao();
    }

    //depositar = ganho de saldo
    //sacar = perda de saldo
    //transferir = perda de saldo e ganho de outro
    //listar = usar instanceof

    // depositar ->
    // sacar ->

    public void managerPage(int keyPage) {
        switch (keyPage) {

            case 0 -> {
                uiView.shutdown();
            }

            case 1 ->{

                String nome = uiView.readTitular("Cadastrar titular", "nome");;
                String cpf_cnpj = uiView.readTitular("Cadastrar titular", "CPF/CNPJ");

                if(cpf_cnpj.length() != 11 && cpf_cnpj.length() != 14){
                    uiView.errorDigits();
                    return;
                }

                try{
                    titularData.insert(nome, cpf_cnpj);
                    uiView.confirmInsert("Titular");
                }catch (SQLException e){
                    uiView.errorDatabase();
                    e.printStackTrace();
                }

            }

            case 2 -> {
                ContaType contaEnum;

                listTitular();
                Integer titular_id = uiView.readId("Registrar Conta", "o titular");
                Titular titular = searchTitular(titular_id);

                if(titular == null){
                    uiView.notFound("o titular");
                    return;
                }

                String numeroConta = uiView.readConta("Registrar Conta");
                int keyType = uiView.typePage();
                contaEnum = managerType(keyType);

                if(contaEnum == null){
                    return;
                }
                String contaTypeString = contaEnum.toString();


                try{
                    contaData.insert(titular, numeroConta, 0, contaTypeString);
                    uiView.confirmInsert("Conta");
                }catch (SQLException e){
                    uiView.errorDatabase();
                    e.printStackTrace();
                }


            }

            //depósito
            //Pesquisa de conta
            //insert de movimentacao
            case 3 -> {
                listConta();
                Integer conta_id = uiView.readId("Depósito", "a conta");
                Conta conta = searchConta(conta_id);

                if(conta == null){
                    uiView.notFound("a conta");
                    return;
                }

                String tipo = MovimentacaoType.DEPOSITO.toString();
                double saldo = uiView.readSaldo("Depósito", "depositar");

                if(saldo <= 0){
                    uiView.saldoNegativo("depósito");
                    return;
                }

                Movimentacao movimentacao = new Movimentacao(conta, conta, tipo, saldo, LocalDateTime.now());

                try{
                    movimentacaoData.insert(movimentacao);
                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
            //saque
            //Pesquisa conta
            //insert de movimentacao
            case 4 -> {
                listConta();
                Integer conta_id = uiView.readId("Saque", "a conta");
                Conta conta = searchConta(conta_id);

                if(conta == null){
                    uiView.notFound("a conta");
                    return;
                }

                String tipo = MovimentacaoType.SAQUE.toString();

                double saldo = uiView.readSaldo("Saque", "sacar");

                if(saldo <= 0){
                    uiView.saldoNegativo("saque");
                    return;
                }

                if((conta.getSaldo() - saldo) < 0){
                    uiView.balanceAbove();
                    return;
                }

                Movimentacao movimentacao = new Movimentacao(conta, conta, tipo, saldo, LocalDateTime.now());

                try{
                    movimentacaoData.insert(movimentacao);
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }

            //transferência
            //pesquisa duas contas
            //diminui saldo do remetente -> update conta: saldo
            //aumenta saldo do destinatário -> update conta: saldo
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
                        uiView.notFound("a conta");
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

    private void listTitular(){
        titulares = titularData.select();

        for(Titular titular: titulares){
            System.out.println(titular);
        }
    }

    private Titular searchTitular(Integer id){
        TitularDao titularData = new TitularDao();
        titulares = titularData.select();
        for(Titular titular: titulares){
            if(Objects.equals(titular.getId(), id)){
                return titular;
            }
        }

        return null;
    }

    private void listConta(){
        try{
            contas = contaData.select();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        for(Conta conta: contas){
            System.out.println(conta);
        }
    }

    private Conta searchConta(Integer id) {
        try{
            contas = contaData.select();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        for (Conta contaUnit : contas) {
            if (Objects.equals(contaUnit.getId(), id)) {
                return contaUnit;
            }
        }
        return null;
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
