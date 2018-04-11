/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.model;

import java.util.Calendar;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 */
public class Selling {

    private Calendar date;

    private String client;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Selling() {
    }

    public Selling(Selling selling) {
        this.date = selling.date;
        this.client = selling.client;
    }

    public Selling(Calendar date, String client) {
        this.date = date;
        this.client = client;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
//</editor-fold>

}
