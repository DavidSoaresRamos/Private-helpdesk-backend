package com.yuziio.helpdesk.ticket.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chips")
public class SIMCard {


    private String name;
    private int ddd;
    private int number;
    private String observation;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
