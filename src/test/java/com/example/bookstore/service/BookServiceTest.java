package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BookServiceTest {

    BookRepository bookRepository;
    BookService bookService;

    @Before // dla każdego testu
    public void setUp() {
        bookRepository = mock(BookRepository.class); //mockowanie
        bookService = new BookService(bookRepository);//do testowania serwisu
    }

    @Test
    public void getListingData() throws Exception {
        //given (zakładając, że: )
        when(bookRepository.findAll()).thenReturn(Lists.newArrayList(
                new Book("titleTest1", "authorTest1"),
                new Book("titleTest2", "authorTest2")
                )
        );
        //when(kiedy wywołamy: )
        BookListing bookListing = bookService.getListingData();
        //then (to otrzymamy: )
        assertEquals(new BookListing(Lists.newArrayList(
                new Book("titleTest1", "authorTest1"),
                new Book("titleTest2", "authorTest2")
        ),
                2
        ), bookListing);
        verify(bookRepository).findAll();

    }
}