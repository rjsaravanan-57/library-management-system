package com.example.Springbootproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Springbootproject.model.Book;
import com.example.Springbootproject.repository.BookRepository;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add Book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Get All Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get Book By ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Update Book
    public Book updateBook(Long id, Book book) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());

        return bookRepository.save(existingBook);
    }

    // Delete Book
    public void deleteBook(Long id) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookRepository.delete(existingBook);
    }
}