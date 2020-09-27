package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddCustomerRequest{
    private String phoneNumber;
    private String customerName;
    private int loanAmount;
    private int khatabookId;
}
