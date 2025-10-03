package com.veritasCapital.bank.model;

public enum MovimentacaoType {

    DEPOSITO("DEPOSITO"),
    SAQUE("SAQUE"),
    TRANSFERENCIA("TRANSFERENCIA");

    private final String ENUM_CHOOSE;

    MovimentacaoType(String ENUM_CHOOSE){
        this.ENUM_CHOOSE = ENUM_CHOOSE;
    }

    @Override
    public String toString() {
        return ENUM_CHOOSE;
    }
}