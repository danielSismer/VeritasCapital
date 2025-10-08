package com.veritasCapital.bank.repository;

import com.veritasCapital.bank.model.Conta;
import com.veritasCapital.bank.model.Movimentacao;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MovimentacaoRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovimentacaoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Movimentacao movimentacao) {
        String query = """
                INSERT INTO movimentacao (
                id
                , conta_remetente
                , conta_destinatario
                , tipo
                , valor
                , data_horario)
                VALUES 
                (?, ?, ?, ?, ?, ?);
                """;
        jdbcTemplate.update(query, movimentacao.getId(), movimentacao.getConta_destinario(),
                movimentacao.getConta_destinario(), movimentacao.getMovimentacaoType(), movimentacao.getValor(), movimentacao.getData_horario());
    }

    public List<Movimentacao> select (){
        String query = """
                SELECT id
                , conta_remetente
                , conta_destinatario
                , tipo
                , valor
                , data_horario
                FROM movimentacao;
                """;

      return jdbcTemplate.query(query, (rs, numRow) ->{

          Conta contaDestinaria = new Conta(rs.getInt("conta_destinario"));
          Conta contaRemetente = new Conta(rs.getInt("conta_remetente"));

          return new Movimentacao(rs.getInt("id"), contaRemetente,
                  contaDestinaria, rs.getString("tipo"),
                  rs.getDouble("valor"), rs.getObject("data_horario", LocalDateTime.class)
          );
      });


    }
}
