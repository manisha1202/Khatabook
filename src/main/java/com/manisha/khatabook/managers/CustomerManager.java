package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.CustomerDao;
import com.manisha.khatabook.dao.exceptions.KhatabookCustomerDaoException;
import com.manisha.khatabook.dao.models.Khatabook;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;
import com.manisha.khatabook.dao.models.request.GetCustomerIdRequest;
import com.manisha.khatabook.dao.models.request.GetCustomersRequest;
import com.manisha.khatabook.dao.models.response.GetCustomerIdResponse;
import com.manisha.khatabook.dao.models.response.GetCustomersResponse;
import com.manisha.khatabook.models.Customer;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        AddCustomerRequest addCustomerRequest = addCustomerRequest(customer);
        try {
            customerDao.addCustomer(addCustomerRequest);
        } catch (KhatabookCustomerDaoException e) {
            e.printStackTrace();
        }

    }

    public GetCustomersResponse getCustomers(Khatabook khatabook) {
        GetCustomersRequest getCustomersRequest = getCustomersRequest(khatabook);
        try {
            return customerDao.getCustomers(getCustomersRequest);
        } catch (KhatabookCustomerDaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AddCustomerRequest addCustomerRequest(@NonNull Customer customer) {
        return AddCustomerRequest
                .builder()
                .customerName(customer.getCustomerName())
                .phoneNumber(customer.getPhoneNumber())
                .amount(customer.getAmount())
                .khatabookId(customer.getKhatabookId())
                .type(customer.getType())
                .build();
    }

    private GetCustomersRequest getCustomersRequest(@NonNull Khatabook khatabook) {
        return GetCustomersRequest.builder()
                .khatabookId(khatabook.getId())
                .build();
    }


}
