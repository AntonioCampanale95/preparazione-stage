package com.example;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ViaggioCSVReader {

    public static void leggiCSVInserisciDB(String path) throws CsvValidationException {
        String query = "INSERT INTO viaggi (destinazione, data_partenza, data_ritorno, budget, attivita) VALUES (?, ?, ?, ?, ?)";

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextline;

            reader.readNext();

            try (Connection conn = GestoreDatabase.getConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {
                while ((nextline = reader.readNext()) != null) {
                    String destinazione = nextline[1];
                    Date data_partenza = Date.valueOf(nextline[2]);
                    Date data_ritorno = Date.valueOf(nextline[3]);
                    double BUDGET = Double.parseDouble(nextline[4]);
                    String attivita = nextline[5];

                    statement.setString(1, destinazione);
                    statement.setDate(2, data_partenza);
                    statement.setDate(3, data_ritorno);
                    statement.setDouble(4, BUDGET);
                    statement.setString(5, attivita);

                    statement.executeUpdate();
                }

                System.out.println("Dati importati correttamente");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
