package com.example.Springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springbootproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}