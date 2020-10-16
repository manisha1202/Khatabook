package com.manisha.khatabook.dao.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDetail {
    private double amount;
    private TransactionType transactionType;
}
