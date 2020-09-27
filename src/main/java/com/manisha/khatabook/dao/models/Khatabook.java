package com.manisha.khatabook.dao.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Khatabook {
    private int id;
    private String name;
    private String fkUserId;
}
