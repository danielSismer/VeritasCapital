package com.banco.service.registrocivil;

import com.banco.dto.DadosRegistroCivil;
import com.banco.model.Titular;

public class RegistroCivilBrasil implements RegistroCivilUniversal{

    @Override
    public Boolean validarTitular() {
        return null;
    }

    @Override
    public DadosRegistroCivil relacionaNacionalidade(Titular titular, String registroCivil) {
        return new DadosRegistroCivil(titular.getNacionalidade(), registroCivil);
    }
}
