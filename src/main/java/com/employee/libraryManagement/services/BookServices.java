package com.employee.libraryManagement.services;

import com.employee.libraryManagement.model.Book;
import com.employee.libraryManagement.repository.H2DBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class BookServices {
    @Autowired
    private H2DBRepository h2DBRepository;

    public Book addBook(Book book) {
        return  h2DBRepository.save(book);
    }
    public void deleteBookById(int id) {
        h2DBRepository.deleteById(id);
    }
    public List<Book> getAllBooks() {
        return h2DBRepository.findAll();
    }
}
