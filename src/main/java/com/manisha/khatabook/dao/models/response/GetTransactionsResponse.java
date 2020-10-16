package com.manisha.khatabook.dao.models.response;

import com.manisha.khatabook.dao.models.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetTransactionsResponse {
    private List<Transaction> transactions;
}
