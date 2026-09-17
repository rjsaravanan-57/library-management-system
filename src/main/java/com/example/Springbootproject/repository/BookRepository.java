package com.example.Springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springbootproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}