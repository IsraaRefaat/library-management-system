package com.esraa.librarymanagementsystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowTransactionDto {

    private Integer bookId;
    private Integer memberId;
    private Integer userId;
    private String notes;

}
