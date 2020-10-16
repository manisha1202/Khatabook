package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import com.manisha.khatabook.dao.models.request.GetTransactionsRequest;
import com.manisha.khatabook.dao.models.response.GetTransactionsResponse;

public interface TransactionDao {
    void addTransaction(AddTransactionRequest addTransactionRequest) throws Exception;

    GetTransactionsResponse getTransactions(GetTransactionsRequest getTransactionsRequest)
            throws Exception;
}
