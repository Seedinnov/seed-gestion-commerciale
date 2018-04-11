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
public class Buying {

    private Calendar date;

    private String provider;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Buying() {
    }

    public Buying(Buying buying) {
        this.date = buying.date;
        this.provider = buying.provider;
    }

    public Buying(Calendar date, String provider) {
        this.date = date;
        this.provider = provider;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
//</editor-fold>

}
