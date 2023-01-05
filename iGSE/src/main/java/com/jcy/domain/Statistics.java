package com.jcy.domain;

public class Statistics {

    private String customer_id;
    private float avg_gas = 0;
    private float avg_ele_day = 0;
    private float avg_ele_night = 0;

    public Statistics() {
    }

    public Statistics(String customer_id, float avg_gas, float avg_ele_day, float avg_ele_night) {
        this.customer_id = customer_id;
        this.avg_gas = avg_gas;
        this.avg_ele_day = avg_ele_day;
        this.avg_ele_night = avg_ele_night;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "customer_id='" + customer_id + '\'' +
                ", avg_gas=" + avg_gas +
                ", avg_ele_day=" + avg_ele_day +
                ", avg_ele_night=" + avg_ele_night +
                '}';
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public float getAvg_gas() {
        return avg_gas;
    }

    public void setAvg_gas(float avg_gas) {
        this.avg_gas = avg_gas;
    }

    public float getAvg_ele_day() {
        return avg_ele_day;
    }

    public void setAvg_ele_day(float avg_ele_day) {
        this.avg_ele_day = avg_ele_day;
    }

    public float getAvg_ele_night() {
        return avg_ele_night;
    }

    public void setAvg_ele_night(float avg_ele_night) {
        this.avg_ele_night = avg_ele_night;
    }
}
