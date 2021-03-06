package com.manisha.khatabook.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Khatabook {
    private int id;
    private String khatabookName;
    private String userPhoneNumber;
    private  double credit;
    private double debit;
}
