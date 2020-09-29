package com.manisha.khatabook.dao.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Transaction {
    private Date date;
    private double amount;
    private String type;
    private String description;
    private int customerId;
    private int khatabookId;
}
