package com.veritasCapital.bank.repository;

import com.veritasCapital.bank.model.Titular;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitularRepository {

    private final JdbcTemplate jdbcTemplate;

    public TitularRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Titular titular) {
        String sql = "INSERT INTO titular (id, nome) VALUES (?, ?)";
        jdbcTemplate.update(sql, titular.getId(), titular.getNome());
    }

    public List<Titular> listarTodos() {
        String sql = "SELECT * FROM titular";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Titular t = new Titular();
            t.setId(rs.getInt("id"));
            t.setNome(rs.getString("nome"));
            return t;
        });
    }
}
