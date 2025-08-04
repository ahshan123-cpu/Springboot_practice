package com.employee.libraryManagement.controller;

import com.employee.libraryManagement.model.Book;
import com.employee.libraryManagement.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServices bookServices;
    @Autowired
    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }
    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return  bookServices.addBook(book);
    }
    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookServices.getAllBooks();
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
         bookServices.deleteBookById(id);
         return "Delete Book Successfully";
    }
}
