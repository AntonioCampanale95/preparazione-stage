package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class ViaggiCSVEsportatore {

    public static void esportaDatiCSV(String path) {
        String query = "SELECT * FROM viaggi";

        try (Connection conn = GestoreDatabase.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        CSVWriter CSVWriter = new CSVWriter(new FileWriter(path))) {

            CSVWriter.writeNext(new String[]{"id", "destinazione", "data_partenza", "data_ritorno", "budget", "attivita"});

            while (rs.next()) {
                int id = rs.getInt("id");
                String destinazione = rs.getString("destinazione");
                Date data_partenza = rs.getDate("data_partenza");
                Date data_ritorno = rs.getDate("data_ritorno");
                double budget = rs.getDouble("budget");
                String attivita = rs.getString("attivita");

                CSVWriter.writeNext(new String[]{
                    String.valueOf(id),
                    destinazione,
                    data_partenza.toString(),
                    data_ritorno.toString(),
                    String.valueOf(budget),
                    attivita
                });
            }
            System.out.println("Dati esportati correttamente");
        }catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

