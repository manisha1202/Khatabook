package com.manisha.khatabook.dao.models.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
    private String phoneNumber;
    private String userName;
    private String email;
    private String address;
    private String image;
}
