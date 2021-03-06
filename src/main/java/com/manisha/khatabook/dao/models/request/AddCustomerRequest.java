package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddCustomerRequest{
    private String phoneNumber;
    private String customerName;
    private double amount;
    private int khatabookId;
    private String type;
}
