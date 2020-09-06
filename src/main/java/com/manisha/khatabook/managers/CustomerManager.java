package com.manisha.khatabook.managers;

import com.manisha.khatabook.dao.CustomerDao;
import com.manisha.khatabook.dao.exceptions.KhatabookCustomerDaoException;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;
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
        try{
            customerDao.addCustomer(addCustomerRequest);
        }catch (KhatabookCustomerDaoException e){
            e.printStackTrace();
        }

    }

    private AddCustomerRequest addCustomerRequest(@NonNull Customer customer) {
        return AddCustomerRequest.builder().customerName(customer.getCustomer_Name())
                .phoneNumber(customer.getPhone_Number()).loanAmount(customer.getLoan_amount())
                .build();
    }
}
