package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookCustomerDaoException;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;

public interface CustomerDao {

    void addCustomer(AddCustomerRequest addCustomerRequest) throws KhatabookCustomerDaoException;
}
