package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.BorrowTransactionDto;
import com.esraa.librarymanagementsystem.entity.Book;
import com.esraa.librarymanagementsystem.entity.BorrowTransaction;
import com.esraa.librarymanagementsystem.entity.Member;
import com.esraa.librarymanagementsystem.entity.User;
import com.esraa.librarymanagementsystem.repository.BookRepo;
import com.esraa.librarymanagementsystem.repository.BorrowTransactionRepo;
import com.esraa.librarymanagementsystem.repository.MemberRepo;
import com.esraa.librarymanagementsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowTransactionService implements BorrowTransactionServiceI{

    @Autowired
    private BorrowTransactionRepo transactionRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private UserRepo userRepo;


    public ResponseEntity<?> borrowBook(BorrowTransactionDto transaction) {
        Book book = bookRepo.findById(transaction.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Member member = memberRepo.findById(transaction.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        User user = userRepo.findById(transaction.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        BorrowTransaction borrowTransaction = new BorrowTransaction();
        borrowTransaction.setBook(book);
        borrowTransaction.setMember(member);
        borrowTransaction.setBorrowByUser(user);
        borrowTransaction.setBorrowDate(LocalDateTime.now());
        borrowTransaction.setStatus("BORROWED");
        borrowTransaction.setNotes(transaction.getNotes());

        transactionRepo.save(borrowTransaction);
        return ResponseEntity.ok(borrowTransaction);
    }

    public ResponseEntity<?> returnBook(Integer id) {
        return transactionRepo.findById(id).map(transaction -> {
            transaction.setReturnDate(LocalDateTime.now());
            transaction.setStatus("RETURNED");
            transactionRepo.save(transaction);
            return ResponseEntity.ok(transaction);
        }).orElse(ResponseEntity.notFound().build());
    }

    public List<BorrowTransaction> getAllTransactions() {
        return transactionRepo.findAll();
    }


    public List<BorrowTransaction> getTransactionsByMember(Integer memberId) {
        return transactionRepo.findByMemberId(memberId);
    }

}
