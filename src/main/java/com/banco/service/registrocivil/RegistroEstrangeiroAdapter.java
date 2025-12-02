package com.banco.service.registrocivil;

import com.banco.dto.DadosRegistroCivil;
import com.banco.model.Titular;

public class RegistroEstrangeiroAdapter implements RegistroCivilUniversal {

    private final RegistroEstrangeiroAdaptee registroEstrangeiro;

    public RegistroEstrangeiroAdapter(RegistroEstrangeiroAdaptee registroEstrangeiro) {
        this.registroEstrangeiro = registroEstrangeiro;
    }

    @Override
    public Boolean validarTitular() {
        return true;
    }

    @Override
    public DadosRegistroCivil relacionaNacionalidade(Titular titular, String cpf) {
        String passportID = titular.getRegistroCivil();

        System.out.println("\n--- [ADAPTER] INICIANDO TRADUÇÃO (CPF -> Passport ID) ---");

        String nacionalidadeTraduzida = registroEstrangeiro.buscarNacionalidadeDoPassport(passportID);
        String registroTraduzido = registroEstrangeiro.buscarIdentificadorNacional(passportID);

        System.out.println("--- [ADAPTER] TRADUÇÃO CONCLUÍDA ---");

        return new DadosRegistroCivil(nacionalidadeTraduzida, registroTraduzido);
    }
}