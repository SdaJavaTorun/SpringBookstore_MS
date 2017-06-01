package com.example.bookstore.model;

import java.util.List;

public class BookListing {
    private List<Book> books;
    private int count;

    public BookListing(List<Book> books, int count) {
        this.books = books;
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookListing that = (BookListing) o;

        if (count != that.count) return false;
        return books.equals(that.books);
    }

    @Override
    public int hashCode() {
        int result = books.hashCode();
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "BookListing: " + '\n' +
                "books = " + books +
                ", count=" + count +
                '\n';
    }
}
