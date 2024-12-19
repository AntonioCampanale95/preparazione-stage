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


        private static Connection connection;
    
        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(url, user, pass);
            
            }
            return connection;
    }


    public static void setConnection(Connection mockConnection) {
        connection = mockConnection;
    }



}
