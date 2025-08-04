package com.employee.services;

import com.employee.libraryManagement.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

public class BookControllerTest {
    private TestRestTemplate  restTemplate;
    @LocalServerPort
    private int port;
    private String baseurl;
    private TestRestTemplate testRestTemplate;
    public void setUp(){
        baseurl = "http://localhost:"+port+"/book";
    }

    @Test
    public void testAddBook(){
        Book book = new Book();
        book.setId(2);
        book.setBookName("Book Name");
        book.setBookAuthor("Book Author");
        book.setBookISBN("Book ISBN");
        ResponseEntity<Book> response = restTemplate.postForEntity(baseurl+"/addBook",book,Book.class);
    }

}
