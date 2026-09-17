package com.example.Springbootproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Springbootproject.model.Author;
import com.example.Springbootproject.repository.AuthorRepository;

@Service
public class AuthorServices {

    private final AuthorRepository authorRepository;

    public AuthorServices(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Add Author
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Get All Authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get Author By ID
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    // Update Author
    public Author updateAuthor(Long id, Author author) {

        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(author.getName());
        existingAuthor.setEmail(author.getEmail());

        return authorRepository.save(existingAuthor);
    }

    // Delete Author
    public void deleteAuthor(Long id) {

        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authorRepository.delete(existingAuthor);
    }
}