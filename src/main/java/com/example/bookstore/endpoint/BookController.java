package com.example.bookstore.endpoint;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDTO;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello/{text}")
    public String hello (@PathVariable("text") String text, Map<String, Object> model){
        model.put("text",text);
        return "hello";
    }

    //@RequestMapping(method = RequestMethod.GET,value="/hello");
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/aaa")
    public String helloworld(){
        return "helloworld";
    }

    @GetMapping()
    public String listing(Map<String, Object> model){
        model.put("time",new Date());
        model.put("listing",bookService.getListingData());
        return "book-listing";
    }
    @PostMapping()
    public String addBook(@ModelAttribute BookDTO book, RedirectAttributes redirectAttributes){
        bookService.addBook(book.fromDto());
        redirectAttributes.addFlashAttribute("result","New book is added to your list.");
        return "redirect:/books";
    }
    @GetMapping("/delete/{book.id}")
    public String deleteBook(@PathVariable int id, RedirectAttributes redirectAttributes){
        bookService.deleteBook(id-1);
        redirectAttributes.addFlashAttribute("deteled","Book" + id + "has been deleted");
        return "redirect:/books";
    }


}
