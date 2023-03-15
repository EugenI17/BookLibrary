package com.ness.library.manager.repositories;

import com.ness.library.manager.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findAllByOrderByAuthorAscTitleAsc();

    List<Book> findByTitle(String title);
}
