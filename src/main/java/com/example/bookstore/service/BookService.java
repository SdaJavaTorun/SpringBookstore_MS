package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RENT on 2017-05-31.
 */
@Component
public class BookService {
    private final BookRepository bookRepository;

    @Autowired // repository zarządzane przez Springa
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BookListing getListingData(){
        List<Book> books = bookRepository.findAll(); // pobieramy książki
        return new BookListing(books, books.size());
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(int id){bookRepository.delete(id);}

}
