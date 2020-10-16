package com.manisha.khatabook.dao.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TotalAmount {
    private double credit;
    private double debit;
}
