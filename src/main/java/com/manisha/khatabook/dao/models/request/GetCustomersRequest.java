package com.manisha.khatabook.dao.models.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
@Builder
public class GetCustomersRequest {
    private  String KhatabookName;
}
