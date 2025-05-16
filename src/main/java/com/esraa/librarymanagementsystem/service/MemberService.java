package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.MemberDto;
import com.esraa.librarymanagementsystem.entity.Member;
import com.esraa.librarymanagementsystem.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MemberService implements MemberServiceI{


    @Autowired
    private MemberRepo memberRepo;

    public ResponseEntity<?> getAllMembers() {
        List<Member> members = memberRepo.findAll();

        if (members.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }

        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    public ResponseEntity<?> addMember(Member member) {
        memberRepo.save(member);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }

    public ResponseEntity<?> updateMember(Integer id, MemberDto memberDto) {
        return memberRepo.findById(id).map(member -> {
            if (memberDto.getName() != null) member.setName(memberDto.getName());
            if (memberDto.getEmail() != null) member.setEmail(memberDto.getEmail());
            if (memberDto.getPhone() != null) member.setPhone(memberDto.getPhone());

            Member updateMember = memberRepo.save(member);
            return ResponseEntity.ok(updateMember);
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }


}
