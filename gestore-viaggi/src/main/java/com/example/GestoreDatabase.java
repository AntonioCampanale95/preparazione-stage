package com.example;

import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.DriverManager;
import java.sql.Connection;

public class GestoreDatabase {

    static Dotenv dotenv = Dotenv.load();
    
        private static final String url = dotenv.get("DB_URL");
        private static final String user = dotenv.get("DB_USERNAME");
        private static final String pass = dotenv.get("DB_PASSWORD");
    
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, pass);
    }

}
