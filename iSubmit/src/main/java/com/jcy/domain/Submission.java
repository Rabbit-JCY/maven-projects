package com.jcy.domain;

import java.net.URL;
import java.util.Date;

public class Submission {

    private Date date;

    private String subNr;

    private String stuId;

    private String url;

    public Submission() {
    }

    @Override
    public String toString() {
        return "Submission{" +
                "date=" + date +
                ", subNr='" + subNr + '\'' +
                ", stuId='" + stuId + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubNr() {
        return subNr;
    }

    public void setSubNr(String subNr) {
        this.subNr = subNr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
