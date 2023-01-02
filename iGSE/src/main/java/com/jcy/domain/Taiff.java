package com.jcy.domain;

public class Taiff {

    private String taiff_type;
    private Float rate;

    public Taiff() {
    }

    public Taiff(String taiff_type, Float rate) {
        this.taiff_type = taiff_type;
        this.rate = rate;
    }

    public String getTaiff_type() {
        return taiff_type;
    }

    public void setTaiff_type(String taiff_type) {
        this.taiff_type = taiff_type;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
