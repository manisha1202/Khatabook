package com.manisha.khatabook.dao.models.response;

import com.manisha.khatabook.dao.models.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetCustomersResponse {
    private List<Customer> customers;
}
