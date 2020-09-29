package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AddTransactionRequest {
    private Date date;
    private double amount;
    private String type;
    private String description;
    private int khatabookId;
    private int customerId;
}
