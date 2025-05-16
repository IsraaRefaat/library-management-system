package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.MemberDto;
import com.esraa.librarymanagementsystem.entity.Member;
import org.springframework.http.ResponseEntity;

public interface MemberServiceI {

    ResponseEntity<?> getAllMembers();

    ResponseEntity<?> addMember(Member member);

    ResponseEntity<?> updateMember(Integer id, MemberDto memberDto);

}
