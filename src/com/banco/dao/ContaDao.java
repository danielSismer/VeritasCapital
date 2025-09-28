package com.banco.dao;

import com.banco.model.Conta;
import com.banco.model.Titular;
import com.banco.utils.Connect;
import com.banco.view.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {

    UserInterface uiView =new UserInterface();

    public void insert(Titular titular, String numero, double saldo, String tipo) throws SQLException{
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

        } catch (SQLException e){
            uiView.errorDatabase();
            e.printStackTrace();
        }
    }

    public List<Conta> select() throws SQLException{
        String sql = """
                SELECT conta.id as id_conta, titular.id as id_titular, titular.nome as nome_titular, numero, saldo, tipo
                from conta
                LEFT JOIN titular on conta.titular = titular.id;
                """;

        List<Conta> contas = new ArrayList<>();

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id_conta = rs.getInt("id_conta");

                Integer id_titular = rs.getInt("id_titular");
                String nome_titular = rs.getString("nome_titular");

                String numero = rs.getString("numero");
                double saldo = rs.getDouble("saldo");
                String tipo = rs.getString("tipo");

                Titular titular = new Titular(id_titular, nome_titular);

                Conta conta = new Conta(id_conta, titular, numero, saldo, tipo);
                contas.add(conta);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return contas;
    }

    public void updateSaldo() throws SQLException{
    }
}
