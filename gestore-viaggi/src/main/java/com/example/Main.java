package com.example;

import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) {
        
        try {
            ViaggioCSVReader.leggiCSVInserisciDB("gestore-viaggi\\viaggi.csv");
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}