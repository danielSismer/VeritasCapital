package com.banco.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnect {

    public static void main(String[] args){

        try(Connection conn = Connect.connect() ){
            if(conn != null){
                System.out.println("Conectado com sucesso!");
            }
            else {
                System.out.println("Conectado não efetivada");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}