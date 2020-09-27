package com.manisha.khatabook.dao.utils;

import com.manisha.khatabook.dao.models.Khatabook;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;
import com.manisha.khatabook.dao.models.request.GetBalanceRequest;
import com.manisha.khatabook.dao.models.response.GetBalanceResponse;
import com.manisha.khatabook.dao.models.response.GetKhatabooksResponse;
import com.manisha.khatabook.dao.models.response.GetUserResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ConverterUtil {

    private ConverterUtil() {

    }

    public static GetUserResponse getUserResponseFromResultSet(ResultSet resultSet)
            throws SQLException {
        return GetUserResponse.builder()
                .phoneNumber(resultSet.getString("Phone_Number"))
                .userName(resultSet.getString("User_Name"))
                .address(resultSet.getString("Address"))
                .email(resultSet.getString("Email"))
                .image(resultSet.getString("Image"))
                .build();
    }

    public static GetKhatabooksResponse getKhatabooksFromResultSet(
            ResultSet resultSet) throws SQLException {
        List<Khatabook> khatabookList = new ArrayList<>();
        while (resultSet.next()) {
            Khatabook khatabook = new Khatabook(resultSet.getInt("Khatabook_Id"),
                    resultSet.getString("Name"),
                    resultSet.getString("users_Phone_Number"));
            khatabookList.add(khatabook);
        }
        return GetKhatabooksResponse.builder().khatabooks(khatabookList).build();
    }


    public static GetBalanceResponse getBalanceFromResultSet(ResultSet rs) throws SQLException{
        return GetBalanceResponse.builder()
                .credit(rs.getInt("credit"))
                .debit(rs.getInt("debit"))
                .build();
    }
}
