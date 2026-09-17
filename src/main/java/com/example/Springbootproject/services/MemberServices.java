package com.example.Springbootproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Springbootproject.model.Member;
import com.example.Springbootproject.repository.MemberRepository;

@Service
public class MemberServices {

    private final MemberRepository memberRepository;

    public MemberServices(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Add Member
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // Get All Members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get Member By ID
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    // Update Member
    public Member updateMember(Long id, Member member) {

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());

        return memberRepository.save(existingMember);
    }

    // Delete Member
    public void deleteMember(Long id) {

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        memberRepository.delete(existingMember);
    }
}