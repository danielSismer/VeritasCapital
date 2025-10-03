package com.veritasCapital.bank.config;

import com.veritasCapital.bank.model.Titular;
import com.veritasCapital.bank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarregaBaseDados {

    TitularRepository t;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaPoupancaRepository contaPoupancaRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private TitularRepository titularRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Bean
    CommandLineRunner executar (){

        return args -> {
            Titular titular = new Titular();
            titular.setNome("Daniel Vinicius Rios Sismer");
            titular.setCpf("15981871213" );
            t.salvar(titular);
        };
    }
}
