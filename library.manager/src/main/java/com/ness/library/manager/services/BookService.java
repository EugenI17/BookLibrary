package com.ness.library.manager.services;

import com.ness.library.manager.dtos.BookDto;
import com.ness.library.manager.entities.Book;
import com.ness.library.manager.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Long save(BookDto bookDto)
    {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .build();
        bookRepository.save(book);
        return book.getId();
    }

    public List<BookDto> getAll()
    {
        return bookRepository.findAllByOrderByAuthorAscTitleAsc().stream().map(book -> BookDto.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .build())
                .collect(Collectors.toList());
    }
    @Transactional
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    public List<BookDto> SearchbyTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(book -> BookDto.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .build())
                .collect(Collectors.toList());
    }
    public void update(BookDto bookDto, Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setAuthor(bookDto.getAuthor());
        bookRepository.save(book);
    }



}
