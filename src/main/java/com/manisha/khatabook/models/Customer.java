package com.manisha.khatabook.models;

import lombok.Data;

@Data
public class Customer {
    private int khatabookId;
    private String customerName;
    private String phoneNumber;
    private int loanAmount;
}
