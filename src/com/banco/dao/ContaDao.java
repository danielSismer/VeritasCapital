package com.banco.dao;

import com.banco.model.Titular;
import com.banco.utils.Connect;
import com.banco.view.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDao {

    UserInterface uiView =new UserInterface();

    public void insert(Titular titular, String numero, double saldo, String tipo){
        String sql = """
                INSERT INTO conta (titular, numero, saldo, tipo)
                VALUES (?, ?, ?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, titular.getId());
            stmt.setString(2, numero);
            stmt.setDouble(3, saldo);
            stmt.setString(4, tipo);

            stmt.executeUpdate();

            uiView.confirmInsert("Conta");

        } catch (SQLException e){
            uiView.errorDatabase();
            e.printStackTrace();
        }
    }
}
