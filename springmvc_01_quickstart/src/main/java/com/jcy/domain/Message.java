package com.jcy.domain;

public class Message {

    private Integer id;
    private Integer from_id;
    private Integer to_id;
    private String information;

    public Message() {
    }

    public Message(Integer id, Integer from_id, Integer to_id, String information) {
        this.id = id;
        this.from_id = from_id;
        this.to_id = to_id;
        this.information = information;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from_id=" + from_id +
                ", to_id=" + to_id +
                ", information='" + information + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Integer from_id) {
        this.from_id = from_id;
    }

    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
