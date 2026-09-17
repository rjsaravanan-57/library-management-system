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

import com.example.Springbootproject.model.Author;
import com.example.Springbootproject.services.AuthorServices;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorServices authorServices;

    public AuthorController(AuthorServices authorServices) {
        this.authorServices = authorServices;
    }

    // Get All Authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorServices.getAllAuthors();
    }

    // Get Author By ID
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorServices.getAuthorById(id);
    }

    // Add Author
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorServices.addAuthor(author);
    }

    // Update Author
    @PutMapping("/{id}")
    public Author updateAuthor(
            @PathVariable Long id,
            @RequestBody Author author) {

        return authorServices.updateAuthor(id, author);
    }

    // Delete Author
    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {

        authorServices.deleteAuthor(id);

        return "Author deleted successfully";
    }
}