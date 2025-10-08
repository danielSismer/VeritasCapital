package com.veritasCapital.bank.repository;

import com.veritasCapital.bank.model.ContaPoupanca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ContaPoupancaRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContaPoupancaRepository (JdbcTemplate jT ){
        this.jdbcTemplate = jT;
    }

    public void salvar (ContaPoupanca contaPoupanca ){
        String query = """
                INSERT INTO conta_poupanca 
                (id, taxaRendimento)
                VALUES 
                (?, ?);
                """;
        jdbcTemplate.update(query, contaPoupanca.getId(), contaPoupanca.getTaxaRendimento());
    }

    public List<ContaPoupanca> select (){
        String query = """
                SELECT id, taxaRendimento
                FROM conta_poupanca
                """;
        return jdbcTemplate.query(query, (rs, numRow) -> {
            var contaPoupanca = new ContaPoupanca();
            contaPoupanca.setId(rs.getInt("id"));
            contaPoupanca.setTaxaRendimento(rs.getDouble("taxaRendimento"));
            return contaPoupanca;
        });
    }
}
