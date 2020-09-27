package com.manisha.khatabook.dao.models.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetBalanceResponse {
    private int debit;
    private int credit;
}
