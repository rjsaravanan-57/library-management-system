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

import com.example.Springbootproject.model.Member;
import com.example.Springbootproject.services.MemberServices;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberServices memberServices;

    public MemberController(MemberServices memberServices) {
        this.memberServices = memberServices;
    }

    // Get All Members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberServices.getAllMembers();
    }

    // Get Member By ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberServices.getMemberById(id);
    }

    // Add Member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberServices.addMember(member);
    }

    // Update Member
    @PutMapping("/{id}")
    public Member updateMember(
            @PathVariable Long id,
            @RequestBody Member member) {

        return memberServices.updateMember(id, member);
    }

    // Delete Member
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {

        memberServices.deleteMember(id);

        return "Member deleted successfully";
    }
}