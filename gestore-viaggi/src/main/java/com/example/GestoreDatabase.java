package com.example;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class GestoreDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/gestore_viaggi";
    private static final String user = "root";
    private static final String pass = "antoniodev";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

}
