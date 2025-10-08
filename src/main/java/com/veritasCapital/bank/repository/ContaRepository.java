package com.veritasCapital.bank.repository;

import com.veritasCapital.bank.model.Conta;
import com.veritasCapital.bank.model.Titular;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class ContaRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Conta conta){
        String query = """
                INSERT INTO Conta
                (id, titular, numero, saldo, tipo)
                VALUES
                (?, ?, ?, ?, ?);
                """;
        jdbcTemplate.update(query, conta.getId(), conta.getTitular(), conta.getNumero(), conta.getSaldo(), conta.getContaType());
        System.out.println("Conta registrada com Sucesso!!!");
    }

    public List<Conta> listar(){
        String sql = """
                SELECT id
                , titular
                , numero
                , saldo
                , tipo
                FROM Conta
                WHERE 1 = 1;
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Conta c = new Conta();
            c.setId(rs.getInt("id"));
            Titular t = new Titular(rs.getInt("titular"));
            c.setTitular(t);
            c.setNumero(rs.getString("numero"));
            c.setSaldo(rs.getDouble("saldo"));
            c.setContaType(rs.getString("tipo"));
            return c;
        });
    }
}
