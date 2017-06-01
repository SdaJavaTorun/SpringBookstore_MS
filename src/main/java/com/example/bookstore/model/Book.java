package com.example.bookstore.model;

public class Book {
    private int id;
    private String name;
    private String author;

    public Book(int id, String name, String author) {
        this.id=id;
        this.name = name;
        this.author = author;
    }

    public int getId() {return id;}

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!name.equals(book.name)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book: " + '\n' +
                "name = " + name +
                ", author = " + author +
                '\n';
    }
}
