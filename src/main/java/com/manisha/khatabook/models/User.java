package com.manisha.khatabook.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String user_name;
    private String phone_number;
    private String password;
    private String email;
    private String address;
    private String image;

}
