package com.jcy.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reading {

    private Integer reading_id;
    private String customer_id;

    DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
    private Date submission_date = fmt.parse(fmt.format(new Date()));
    private float elec_readings_day;
    private float elet_reading_night;
    private float gas_reading;
    private String status = "pending";

    public Reading() throws ParseException {
    }

    public Reading(String customer_id, float elec_readings_day, float elet_reading_night, float gas_reading) throws ParseException {
        this.customer_id = customer_id;

        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("date:" + fmt.parse(fmt.format(new Date())).toString());
        this.submission_date = fmt.parse(fmt.format(new Date()));
        this.elec_readings_day = elec_readings_day;
        this.elet_reading_night = elet_reading_night;
        this.gas_reading = gas_reading;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "reading_id=" + reading_id +
                ", customer_id='" + customer_id + '\'' +
                ", submission_date=" + submission_date +
                ", elec_readings_day=" + elec_readings_day +
                ", elet_reading_night=" + elet_reading_night +
                ", gas_reading=" + gas_reading +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getReading_id() {
        return reading_id;
    }

    public void setReading_id(Integer reading_id) {
        this.reading_id = reading_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }

    public float getElec_readings_day() {
        return elec_readings_day;
    }

    public void setElec_readings_day(float elec_readings_day) {
        this.elec_readings_day = elec_readings_day;
    }

    public float getElet_reading_night() {
        return elet_reading_night;
    }

    public void setElet_reading_night(float elet_reading_night) {
        this.elet_reading_night = elet_reading_night;
    }

    public float getGas_reading() {
        return gas_reading;
    }

    public void setGas_reading(float gas_reading) {
        this.gas_reading = gas_reading;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
