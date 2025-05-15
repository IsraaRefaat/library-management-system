package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Integer> {
}
