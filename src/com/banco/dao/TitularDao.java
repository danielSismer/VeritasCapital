package com.banco.dao;

import com.banco.model.Titular;
import com.banco.utils.Connect;
import com.banco.view.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitularDao {

    UserInterface uiView =new UserInterface();

    public void insert(String nome, String cpf){
        String sql = """
                INSERT INTO titular (nome, cpf)
                VALUES (?, ?);
                """;

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);
            stmt.setString(2, cpf);

            stmt.executeUpdate();

            uiView.confirmInsert("Titular");

        }catch (SQLException e){
            uiView.errorDatabase();
            e.printStackTrace();
        }
    }

    public List<Titular> select(){
        String sql = """
                select id, nome, cpf
                from titular;
                """;

        List<Titular> titulares = new ArrayList<>();

        try(Connection conn = Connect.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");

                Titular titular = new Titular(id, nome, cpf);

                titulares.add(titular);
            }

        }catch (SQLException e){
            uiView.errorDatabase();
            e.printStackTrace();
        }

        return titulares;
    }
}
