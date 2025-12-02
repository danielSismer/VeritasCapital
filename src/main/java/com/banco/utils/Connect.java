package com.banco.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final String URL = "jdbc:mysql://root:dMDMmoAaivHIbupHVDBxKJOyastaroza@centerbeam.proxy.rlwy.net:35576/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "dMDMmoAaivHIbupHVDBxKJOyastaroza";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
