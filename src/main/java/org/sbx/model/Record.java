package org.sbx.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by isilme on 4/14/17.
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;
    private Date date;
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return "ID: " + id +
                " | TITLE: " + title +
                " | AUTHOR: " + author +
                " | DATE: " + date.toString() +
                " | TEXT: " + body;
    }
}
