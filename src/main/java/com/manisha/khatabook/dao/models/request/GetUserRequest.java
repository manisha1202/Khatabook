package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserRequest {

    private String phoneNumber;
    private String password;
}
