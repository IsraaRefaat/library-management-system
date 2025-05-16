package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.BorrowTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowTransactionRepo extends JpaRepository<BorrowTransaction, Integer> {
    List<BorrowTransaction> findByMemberId(Integer memberId);
}
