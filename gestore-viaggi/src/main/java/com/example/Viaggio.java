package com.example;

import java.sql.Date;

public class Viaggio {

    private int id;
    private String destinazione;
    private Date data_partenza;
    private Date data_ritorno;
    private double BUDGET; 
    private String attivita;

    public Viaggio(int id, String destinazione, Date data_partenza, Date data_ritorno, double BUDGET, String attivita) {
        this.id = id;
        this.destinazione = destinazione;
        this.data_partenza = data_partenza;
        this.data_ritorno = data_ritorno;
        this.BUDGET = BUDGET;
        this.attivita = attivita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public Date getData_Partenza(){
        return data_partenza;
    }

    public void setData_Partenza(Date data_partenza){
        this.data_partenza = data_partenza;
    }

    public Date getData_ritorno(){
        return data_ritorno;
    }

    public void setData_Ritorno(Date data_ritorno){
        this.data_ritorno = data_ritorno;
    }

    public double getBudget(){
        return BUDGET;
    }

    public void setBudget(double BUDGET){
        this.BUDGET = BUDGET;
    }

    public String getAttivita(){
        return attivita;
    }

    public void setAttivita(String attivita){
        this.attivita = attivita;
    }


    public String toString(){
        return "Viaggio{id=" + id + ", destinazione='" + destinazione + "', dataPartenza=" + data_partenza + ", dataRitorno=" + data_ritorno + ", budget=" + BUDGET + ", attivita='" + attivita + "'}";
        
    }

}
