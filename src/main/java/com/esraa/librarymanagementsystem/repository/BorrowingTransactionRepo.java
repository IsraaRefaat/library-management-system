package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.BorrowTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingTransactionRepo extends JpaRepository<BorrowTransaction, Integer> {
}
