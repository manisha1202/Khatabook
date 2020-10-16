package com.manisha.khatabook.controllers;

import com.manisha.khatabook.dao.models.Khatabook;
import com.manisha.khatabook.dao.models.response.GetCustomersResponse;
import com.manisha.khatabook.managers.CustomerManager;
import com.manisha.khatabook.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerManager customerManager;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer) {
        try {
            customerManager.addCustomer(customer);
        } catch (Exception e) {
            System.out.println("Failed to add customer." + e.getStackTrace());
            e.printStackTrace();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/customerList", method = RequestMethod.POST)
    public GetCustomersResponse getCustomerList(@RequestBody Khatabook khatabook) {
        try {
            return customerManager.getCustomers(khatabook);
        } catch (Exception e) {
            System.out.println("Failed to add customer." + e.getStackTrace());
            e.printStackTrace();
        }
        return null;
    }
}
