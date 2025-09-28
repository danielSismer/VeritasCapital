package com.banco.dao;

import com.banco.model.Movimentacao;
import com.banco.utils.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MovimentacaoDao {
    public void insert(Movimentacao movimentacao) throws SQLException{
        String sql = """
                INSERT INTO movimentacao (conta_remetente, conta_destinatario, tipo, valor, data_horario)
                values (?, ?, ?, ?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, movimentacao.getConta_remetente().getId());
            stmt.setInt(2, movimentacao.getConta_destinario().getId());
            stmt.setString(3, movimentacao.getMovimentacaoType());
            stmt.setDouble(4, movimentacao.getValor());
            stmt.setObject(5, movimentacao.getData_horario());

            stmt.executeUpdate();

        }
    }
}
