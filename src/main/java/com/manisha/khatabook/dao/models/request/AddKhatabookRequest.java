package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddKhatabookRequest {
    private String khatabookName;
    private String userPhoneNumber;
    private double credit;
    private double debit;
}
