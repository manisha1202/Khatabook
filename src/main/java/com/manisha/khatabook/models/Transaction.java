package com.manisha.khatabook.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Transaction {
    private int id;
    private double amount;
    private Date date;
    private String type;
    private String description;
    private int customerId;
    private int khatabookId;
}
