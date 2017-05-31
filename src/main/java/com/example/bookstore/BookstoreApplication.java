package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //ComponentScan (skanowanie komponentów)
public class BookstoreApplication implements CommandLineRunner {


	private final BookService bookService;
	@Value("${mymessage}")
	private String message;

	@Autowired
	public BookstoreApplication(BookService bookService){
		this.bookService = bookService;
	}


	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(BookstoreApplication.class, args);
		System.out.println("Stop");
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(message);
//		bookService.addBook(new Book("title1","author1"));
//		bookService.addBook(new Book("title2","author2"));
//
//		System.out.println(bookService.getListingData());
	}
}
