package com.manisha.khatabook.dao.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private double amount;
}
