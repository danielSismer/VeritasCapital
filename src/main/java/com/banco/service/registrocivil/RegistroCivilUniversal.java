package com.banco.service.registrocivil;

import com.banco.dto.DadosRegistroCivil;
import com.banco.model.Titular;

public interface RegistroCivilUniversal {

    Boolean validarTitular();

    DadosRegistroCivil relacionaNacionalidade(Titular titular, String cpf);
}

