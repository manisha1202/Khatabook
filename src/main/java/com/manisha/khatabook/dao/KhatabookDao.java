package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookListOfUserDaoException;
import com.manisha.khatabook.dao.models.TotalAmount;
import com.manisha.khatabook.dao.models.request.AddKhatabookRequest;
import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import com.manisha.khatabook.dao.models.request.GetBalanceRequest;
import com.manisha.khatabook.dao.models.request.GetKhatabooksRequest;
import com.manisha.khatabook.dao.models.response.GetBalanceResponse;
import com.manisha.khatabook.dao.models.response.GetKhatabooksResponse;

public interface KhatabookDao {
    void addKhatabook(AddKhatabookRequest addKhatabookRequest) throws Exception;

    GetBalanceResponse getBalance(GetBalanceRequest getBalanceRequest) throws Exception;

    GetKhatabooksResponse getKhatabooks(
            GetKhatabooksRequest getKhatabooksRequest)
            throws KhatabookListOfUserDaoException;


    void updateKhatabook(AddTransactionRequest addTransactionRequest,
                         TotalAmount totalAmount);
}
