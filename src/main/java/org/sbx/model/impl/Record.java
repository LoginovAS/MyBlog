package org.sbx.model.impl;

import org.sbx.model.DBObject;

import java.util.Date;

public class Record implements DBObject {

    private int id;
    private String title;
    private String author;
    private Date date;
    private String body;

    public Builder newBuilder(){
        return new Builder();
    }

    public class Builder{

        Builder(){ }

        public Builder setId(int id) {
            Record.this.id = id;

            return this;
        }

        public Builder setAuthor(String author) {
            Record.this.author = author;

            return this;
        }

        public Builder setDate(Date date) {
            Record.this.date = date;

            return this;
        }

        public Builder setBody(String body) {
            Record.this.body = body;

            return this;
        }

        public Builder setTitle(String title) {
            Record.this.title = title;

            return this;
        }

        public Record build(){
            return Record.this;
        }
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return "ID: " + id +
                " | TITLE: " + title +
                " | AUTHOR: " + author +
                " | DATE: " + date.toString() +
                " | TEXT: " + body;
    }
}
