package com.example.Springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springbootproject.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}