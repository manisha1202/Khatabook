package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTransactionsRequest {
    private int khatabookId;
    private int customerId;
}
