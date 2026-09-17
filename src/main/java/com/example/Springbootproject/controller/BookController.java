package com.example.Springbootproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springbootproject.model.Book;
import com.example.Springbootproject.services.BookServices;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    // Get All Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookServices.getAllBooks();
    }

    // Get Book By ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookServices.getBookById(id);
    }

    // Add Book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookServices.addBook(book);
    }

    // Update Book
    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {

        return bookServices.updateBook(id, book);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookServices.deleteBook(id);

        return "Book deleted successfully";
    }
}