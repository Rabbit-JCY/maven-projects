package com.jcy.domain;

public class Customer {

    private String customer_id;
    private String password_hash;
    private String address;
    private String property_type;
    private Integer bedroom_num;
    private float balance;
    private String type;

    public Customer() {
    }

    public Customer(String customer_id, String password_hash, String address, String property_type, Integer bedroom_num, float balance, String type) {
        this.customer_id = customer_id;
        this.password_hash = password_hash;
        this.address = address;
        this.property_type = property_type;
        this.bedroom_num = bedroom_num;
        this.balance = balance;
        this.type = type;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public Integer getBedroom_num() {
        return bedroom_num;
    }

    public void setBedroom_num(Integer bedroom_num) {
        this.bedroom_num = bedroom_num;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
