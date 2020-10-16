package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCustomerIdRequest {
    private String customerName;
    private int khatabookId;
}
