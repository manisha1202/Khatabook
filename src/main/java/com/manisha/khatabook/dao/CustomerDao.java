package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookCustomerDaoException;
import com.manisha.khatabook.dao.models.TransactionDetail;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;
import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import com.manisha.khatabook.dao.models.request.GetCustomersRequest;
import com.manisha.khatabook.dao.models.response.GetCustomersResponse;

public interface CustomerDao {

    void addCustomer(AddCustomerRequest addCustomerRequest) throws KhatabookCustomerDaoException;

    GetCustomersResponse getCustomers(GetCustomersRequest getCustomersRequest)
            throws KhatabookCustomerDaoException;

    void updateCustomer(AddTransactionRequest addTransactionRequest,
                        TransactionDetail transactionDetail) throws Exception;
}
