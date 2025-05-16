package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.dto.MemberDto;
import com.esraa.librarymanagementsystem.entity.Member;
import com.esraa.librarymanagementsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping
    public ResponseEntity<?> getMembers() {
        return memberService.getAllMembers();
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping
    public ResponseEntity<?> addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Integer id, @RequestBody MemberDto member) {
        return memberService.updateMember(id, member);
    }

}
