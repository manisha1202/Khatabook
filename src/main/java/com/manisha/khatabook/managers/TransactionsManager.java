package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.TransactionDao;
import com.manisha.khatabook.models.Transaction;
import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import com.manisha.khatabook.dao.models.request.GetTransactionsRequest;
import com.manisha.khatabook.dao.models.response.GetTransactionsResponse;
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

    public GetTransactionsResponse getTransactions(Transaction transaction) {
        GetTransactionsRequest getTransactionsRequest = getTransactionsRequest(transaction);
        try {
            return transactionDao.getTransactions(getTransactionsRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private GetTransactionsRequest getTransactionsRequest(@NonNull Transaction transaction) {
        return GetTransactionsRequest.builder()
                .customerId(transaction.getCustomerId())
                .khatabookId(transaction.getKhatabookId())
                .build();
    }
}
