package com.uob.bank.SpringBoot2_4.model;

public class Greetings {

    private int id;
    private String  content;

    public Greetings(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
