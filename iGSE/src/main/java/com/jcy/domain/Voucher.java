package com.jcy.domain;

public class Voucher {

    private String EVC_code;
    private Integer used;

    public Voucher() {
    }

    public Voucher(String EVC_code, Integer used) {
        this.EVC_code = EVC_code;
        this.used = used;
    }

    public String getEVC_code() {
        return EVC_code;
    }

    public void setEVC_code(String EVC_code) {
        this.EVC_code = EVC_code;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}
