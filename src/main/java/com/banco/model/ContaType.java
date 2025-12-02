package com.banco.model;

public enum ContaType {

    CONTA_CORRENTE("CONTA_CORRENTE"),
    CONTA_POUPANCA("CONTA_POUPANCA");

    private final String ENUM_CHOOSE;

    ContaType(String ENUM_CHOOSE){
        this.ENUM_CHOOSE = ENUM_CHOOSE;
    }

    @Override
    public String toString(){
        return ENUM_CHOOSE;
    }
}
