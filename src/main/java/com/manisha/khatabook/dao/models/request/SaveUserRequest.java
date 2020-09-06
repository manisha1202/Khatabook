package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveUserRequest {
    private String userName;
    private String phoneNumber;
    private String password;
    private String email;
    private String address;
    private String image;
}
