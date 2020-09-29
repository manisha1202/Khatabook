package com.manisha.khatabook.dao.models.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetBalanceResponse {
    private double debit;
    private double credit;
}
