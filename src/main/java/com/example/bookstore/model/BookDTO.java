package com.example.bookstore.model;

/**
 * Created by RENT on 2017-06-01.
 */
public class BookDTO {
    private int id;
    private String name;
    private String author;

    public BookDTO(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Book fromDto(){
        return new Book(id, name, author); // zamiana DTO na Book
    }
}
