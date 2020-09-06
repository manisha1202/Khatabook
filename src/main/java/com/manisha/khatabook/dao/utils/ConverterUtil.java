package com.manisha.khatabook.dao.utils;

import com.manisha.khatabook.dao.models.response.GetUserResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ConverterUtil {

    private ConverterUtil() {

    }

    public static GetUserResponse GetUserResponseFromResultSet(ResultSet resultSet)
            throws SQLException {
        return GetUserResponse.builder()
                .phoneNumber(resultSet.getString("Phone_Number"))
                .userName(resultSet.getString("User_Name"))
                .address(resultSet.getString("Address"))
                .email(resultSet.getString("Email"))
                .image(resultSet.getString("Image"))
                .build();
    }
}
