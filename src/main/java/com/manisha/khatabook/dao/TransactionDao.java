package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.models.request.AddTransactionRequest;

public interface TransactionDao {
    void addTransaction(AddTransactionRequest addTransactionRequest) throws Exception;
}
