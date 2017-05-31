package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceSpringTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @Before
    public void setUp(){ //tutaj, rzeczywista implementacja
        //bookRepository.deleteAll() -- żeby czyścić listę przed każdym testem
        bookRepository.save(new Book("titleSpringTest1","authorSpringTest1"));
        bookRepository.save(new Book("titleSpringTest2","authorSpringTest2"));
    }

    @Test
    public void getListingData() throws Exception { // przy tym teście nie powinno być logiki, więc zakomentuj klasę run w aplikacji
        //given -- pusta, nie potrzeba już więcej informacji
        //when
        BookListing bookListing = bookService.getListingData();
        //then
        assertEquals(new BookListing(
                Lists.newArrayList(
                    new Book("titleSpringTest1","authorSpringTest1"),
                    new Book("titleSpringTest2","authorSpringTest2")),
                2), bookListing
        );
    }

}