package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetKhatabookListOfUserRequest {
    private String phoneNumber;
}
