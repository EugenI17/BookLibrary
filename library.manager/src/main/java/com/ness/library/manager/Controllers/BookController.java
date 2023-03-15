package com.ness.library.manager.Controllers;

import com.ness.library.manager.dtos.BookDto;
import com.ness.library.manager.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/library")
public class BookController {

    private final BookService bookService;
    @GetMapping("/books")
   public List<BookDto> getAllBooks()
    {
        return bookService.getAll();
    }
    @PostMapping("/Createbooks")
    public void createBook(@RequestBody BookDto bookDto)
    {
        bookService.save(bookDto);
    }
    @DeleteMapping("/Deletebooks")
    public void deleteBook(@RequestParam Long id)
    {
        bookService.deleteById(id);
    }
    @GetMapping("/Searchbooks")
    public List<BookDto> SearchBook(@RequestParam String title)
    {
        return bookService.SearchbyTitle(title);
    }
    @PutMapping("/Updatebooks")
    public void UpdateBook(@RequestBody BookDto bookDto, @RequestParam Long id)
    {
        bookService.update(bookDto,id);
    }



}
