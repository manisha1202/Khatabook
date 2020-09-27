package com.manisha.khatabook.dao.models.response;

import com.manisha.khatabook.dao.models.Khatabook;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetKhatabooksResponse {
    private List<Khatabook> khatabooks;
}
