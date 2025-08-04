package com.employee.libraryManagement.repository;

import com.employee.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2DBRepository extends JpaRepository<Book, Integer> {
}
