package com.manisha.khatabook.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private int khatabookId;
    private String customerName;
    private String phoneNumber;
    private int loanAmount;
}
