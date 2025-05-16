package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.BorrowTransactionDto;
import com.esraa.librarymanagementsystem.entity.BorrowTransaction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BorrowTransactionServiceI {

    ResponseEntity<?> borrowBook(BorrowTransactionDto transaction);

    ResponseEntity<?> returnBook(Integer id);

    List<BorrowTransaction> getAllTransactions();


    List<BorrowTransaction> getTransactionsByMember(Integer memberId);

}
