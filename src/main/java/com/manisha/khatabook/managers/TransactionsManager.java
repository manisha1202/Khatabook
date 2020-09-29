package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.TransactionDao;
import com.manisha.khatabook.dao.models.Transaction;
import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsManager {

    @Autowired
    private TransactionDao transactionDao;

    public void addTransaction(Transaction transaction) {
        AddTransactionRequest addTransactionRequest =
                addTransactionRequest(transaction);
        try {
            transactionDao.addTransaction(addTransactionRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AddTransactionRequest addTransactionRequest(@NonNull Transaction transaction) {
        return AddTransactionRequest.builder()
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .type(transaction.getType())
                .description(transaction.getDescription())
                .customerId(transaction.getCustomerId())
                .khatabookId(transaction.getKhatabookId()).build();
    }
}
