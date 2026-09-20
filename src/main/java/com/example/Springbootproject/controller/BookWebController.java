package com.example.Springbootproject.controller;

import com.example.Springbootproject.model.Author;
import com.example.Springbootproject.model.Book;
import com.example.Springbootproject.services.AuthorServices;
import com.example.Springbootproject.services.BookServices;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookWebController {

    private final BookServices bookServices;
    private final AuthorServices authorServices;

    public BookWebController(
            BookServices bookServices,
            AuthorServices authorServices) {

        this.bookServices = bookServices;
        this.authorServices = authorServices;
    }


    // ------------------------------------------------
    // SHOW ALL BOOKS
    // ------------------------------------------------

    @GetMapping
    public String showBooks(Model model) {

        model.addAttribute("books", bookServices.getAllBooks());

        return "books";
    }


    // ------------------------------------------------
    // SHOW ADD BOOK FORM
    // ------------------------------------------------

    @GetMapping("/new")
    public String showAddBookForm(Model model) {

        model.addAttribute("book", new Book());

        // Send authors to the HTML page
        model.addAttribute(
                "authors",
                authorServices.getAllAuthors()
        );

        return "add-book";
    }


    // ------------------------------------------------
    // SAVE BOOK
    // ------------------------------------------------

    @PostMapping("/save")
    public String saveBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult result,
            @RequestParam Long authorId,
            Model model) {

        // If validation fails
        if (result.hasErrors()) {

            model.addAttribute(
                    "authors",
                    authorServices.getAllAuthors()
            );

            return "add-book";
        }


        // Find selected author
        Author author =
                authorServices.getAuthorById(authorId);

        // Set author to book
        book.setAuthor(author);


        // Save book
        bookServices.addBook(book);


        // Go back to books page
        return "redirect:/books";
    }


    // ------------------------------------------------
    // SHOW EDIT BOOK FORM
    // ------------------------------------------------

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        // Get existing book
        Book book =
                bookServices.getBookById(id);

        model.addAttribute("book", book);


        // Send authors to edit page
        model.addAttribute(
                "authors",
                authorServices.getAllAuthors()
        );

        return "edit-book";
    }


    // ------------------------------------------------
    // UPDATE BOOK
    // ------------------------------------------------

    @PostMapping("/update/{id}")
    public String updateBook(
            @PathVariable Long id,
            @Valid @ModelAttribute("book") Book book,
            BindingResult result,
            @RequestParam Long authorId,
            Model model) {

        // If validation fails
        if (result.hasErrors()) {

            model.addAttribute(
                    "authors",
                    authorServices.getAllAuthors()
            );

            return "edit-book";
        }


        // Find selected author
        Author author =
                authorServices.getAuthorById(authorId);


        // Set author
        book.setAuthor(author);


        // Update book
        bookServices.updateBook(id, book);


        // Go back to books page
        return "redirect:/books";
    }


    // ------------------------------------------------
    // DELETE BOOK
    // ------------------------------------------------

    @GetMapping("/delete/{id}")
    public String deleteBook(
            @PathVariable Long id) {

        bookServices.deleteBook(id);

        return "redirect:/books";
    }

}