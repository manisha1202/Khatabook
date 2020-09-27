package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookCustomerDaoException;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;
import com.manisha.khatabook.dao.models.request.GetCustomersRequest;
import com.manisha.khatabook.dao.models.response.GetCustomersResponse;

public interface CustomerDao {

    void addCustomer(AddCustomerRequest addCustomerRequest) throws KhatabookCustomerDaoException;

    GetCustomersResponse getCustomers(GetCustomersRequest getCustomersRequest) throws KhatabookCustomerDaoException;;
}
