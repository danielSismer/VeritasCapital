package com.banco.service.registrocivil;

public class RegistroEstrangeiroAdaptee {

    public String buscarIdentificadorNacional(String passportID) {
        System.out.println("-> [Adaptee] Buscando identificador estrangeiro com PassportID: " + passportID);
        return "ID_Estrangeiro_" + passportID;
    }

    public String buscarNacionalidadeDoPassport(String passportID) {
        System.out.println("-> [Adaptee] Buscando nacionalidade para PassportID: " + passportID);
        return "Estrangeira (Passport)";
    }
}