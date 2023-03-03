package com.jcy.domain;

public class Feedback {

    private String subNr;

    private  String text;

    private Integer mark;

    public Feedback() {
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "subNr='" + subNr + '\'' +
                ", text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }

    public String getSubNr() {
        return subNr;
    }

    public void setSubNr(String subNr) {
        this.subNr = subNr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
