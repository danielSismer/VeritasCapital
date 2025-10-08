package com.veritasCapital.bank.repository;

import com.veritasCapital.bank.model.ContaCorrente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ContaCorrenteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContaCorrenteRepository (JdbcTemplate jT){
        this.jdbcTemplate = jT;
    }

    public void salvar (ContaCorrente cc ){
            String sql = """
                    INSERT INTO conta_corrente (id, movimentacaoDiaria)
                    VALUES (?, ?);
                    """;
            jdbcTemplate.update(sql, cc.getId(), cc.getMovimentacaoDiaria());
        System.out.println("Conta Corrente registrada com Sucesso!!!");
    }

    public List<ContaCorrente> listar (){
        String query = """
                SELECT id, movimentacaoDiaria
                FROM conta_corrente
                """;
        return jdbcTemplate.query(query, (rs, numRow) -> {
            var c = new ContaCorrente();
            c.setId(rs.getInt("id"));
            c.setMovimentacaoDiaria(rs.getDouble("movimentacaoDiaria"));
            return c;
        });

    }
}
