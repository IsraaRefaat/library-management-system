package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.dto.BorrowTransactionDto;
import com.esraa.librarymanagementsystem.entity.BorrowTransaction;
import com.esraa.librarymanagementsystem.service.BorrowTransactionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("borrow")
public class BorrowTransactionController {

    @Autowired
    private BorrowTransactionServiceI borrowTransactionService;

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping
    public ResponseEntity<?> borrowBook(@RequestBody BorrowTransactionDto transaction) {
        return borrowTransactionService.borrowBook(transaction);
    }

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PatchMapping("{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable Integer id) {
        return borrowTransactionService.returnBook(id);
    }

    @PreAuthorize("hasRole('ADMIM')")
    @GetMapping
    public List<BorrowTransaction> getAllTransactions() {
        return borrowTransactionService.getAllTransactions();
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping("member/{memberId}")
    public List<BorrowTransaction> getTransactionsByMember(@PathVariable Integer memberId) {
        return borrowTransactionService.getTransactionsByMember(memberId);
    }

}
