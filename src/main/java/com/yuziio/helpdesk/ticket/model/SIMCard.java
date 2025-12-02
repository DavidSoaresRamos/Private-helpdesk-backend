package com.yuziio.helpdesk.ticket.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chips")
public class SIMCard {


    private String name;
    private int ddd;
    private int number;


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

}
