package com.jcy.domain;

public class Module {

    private String code;

    private String title;

    public Module() {
    }

    @Override
    public String toString() {
        return "Module{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
