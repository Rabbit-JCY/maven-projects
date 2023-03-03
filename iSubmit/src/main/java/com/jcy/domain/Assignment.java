package com.jcy.domain;

import java.util.Date;

public class Assignment {

    private Date dueDate;

    private String name;

    public Assignment() {
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "dueDate=" + dueDate +
                ", name='" + name + '\'' +
                '}';
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
