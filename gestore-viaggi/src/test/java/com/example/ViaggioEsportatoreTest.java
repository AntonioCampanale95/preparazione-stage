package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.cdimascio.dotenv.Dotenv;

public class ViaggioEsportatoreTest {

        @BeforeAll
static void setup() throws ClassNotFoundException {

    Class.forName("org.h2.Driver");
    System.setProperty("DB_URL", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
    System.setProperty("DB_USERNAME", "sa");
    System.setProperty("DB_PASSWORD", "password");

}


    @Test
    void testEsportatore() throws SQLException, FileNotFoundException, IOException, CsvValidationException {

        try (Connection conn = DriverManager.getConnection(System.getProperty("DB_URL"), System.getProperty("DB_USERNAME"), System.getProperty("DB_PASSWORD"));
        Statement stmt = conn.createStatement()) {
            
            stmt.execute("CREATE TABLE viaggi (" +
            "id INT PRIMARY KEY," +
            "destinazione VARCHAR(255)," +
            "data_partenza DATE," + 
            "data_ritorno DATE," +
            "budget double," +
            "attivita VARCHAR(255)" +
            ")");


            stmt.execute("INSERT INTO viaggi (id, destinazione, data_partenza, data_ritorno, budget, attivita) " +
            "VALUES (1, 'Roma', '2024-05-01', '2024-05-10', 1000.00, 'Tour storico')");
            stmt.execute("INSERT INTO viaggi (id, destinazione, data_partenza, data_ritorno, budget, attivita) " +
            "VALUES (2, 'Parigi', '2024-06-01', '2024-06-07', 1500.00, 'Tour gastronomico')");


            String fileTemp = "C:\\Users\\anton\\Desktop\\viaggi_test.csv";
            ViaggiCSVEsportatore.esportaDatiCSV(fileTemp);

            File csvFile = new File(fileTemp);
            assertTrue(csvFile.exists(), "Il file csv dovrebbe esistere");

            try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
                String[] righeIntestazione = reader.readNext();
                assertArrayEquals(new String[]{"id", "destinazione", "data_partenza", "data_ritorno", "budget", "attivita"}, righeIntestazione, "Lì'intestazione del csv non corrisponde");

                String[] riga1 = reader.readNext();
                assertNotNull(riga1, "La prima riga non dovrebbe essere nulla");
                assertArrayEquals(new String[]{"1", "Roma", "2024-05-01", "2024-05-10", "1000.00", "Tour storico"}, riga1);

                String[] riga2 = reader.readNext();
                assertNotNull(riga2, "La seconda riga non dovrebbe essere nulla");
                assertArrayEquals(new String[]{"2", "Parigi", "2024-06-01", "2024-06-07", "1500.00", "Tour gastronomico"}, riga2);
          
            }
        }
    }

    @AfterAll
    static void pulisciCSV() {
        File csvFile = new File("test_viaggi.csv");
        if (csvFile.exists()) {
            csvFile.delete();
        }
    }






}