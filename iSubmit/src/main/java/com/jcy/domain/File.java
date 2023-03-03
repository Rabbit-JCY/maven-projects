package com.jcy.domain;

import java.net.URL;

public class File {

    private String name;

    private String content;

    private String url;

    public File() {
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", url=" + url +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
