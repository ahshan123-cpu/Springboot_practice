package com.employee.services;

import com.employee.libraryManagement.model.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTest {
    @LocalServerPort
    private int port;
    private String baseurl;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp(){
        baseurl = "http://localhost:"+port+"/book";
    }

    @Test
    public void testAddBook(){
        Book book = new Book();
        System.out.println("port "+port);
        book.setId(2);
        book.setBookName("Java Master");
        book.setBookAuthor("Ahshan");
        book.setBookISBN("7896544123");
        ResponseEntity<Book> response = testRestTemplate.postForEntity(baseurl,book,Book.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        assertEquals("Java Master", response.getBody().getBookName());
        assertTrue(response.getBody().getBookAuthor().equals("Ahshan"));
        System.out.println("Book Added Test Successfully");
    }
}
