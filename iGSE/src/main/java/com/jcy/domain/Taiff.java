package com.jcy.domain;

public class Taiff {

    private String taiff_type;
    private Integer rate;

    public Taiff() {
    }

    public Taiff(String taiff_type, Integer rate) {
        this.taiff_type = taiff_type;
        this.rate = rate;
    }

    public String getTaiff_type() {
        return taiff_type;
    }

    public void setTaiff_type(String taiff_type) {
        this.taiff_type = taiff_type;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
