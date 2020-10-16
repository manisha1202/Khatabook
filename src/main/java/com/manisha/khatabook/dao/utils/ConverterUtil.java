package com.manisha.khatabook.dao.utils;

import com.manisha.khatabook.dao.models.Customer;
import com.manisha.khatabook.dao.models.Khatabook;
import com.manisha.khatabook.dao.models.Transaction;
import com.manisha.khatabook.dao.models.response.*;

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


    public static GetBalanceResponse getBalanceFromResultSet(ResultSet rs) throws SQLException {
        System.out.println(rs.next());
//        System.out.println(rs);
        return GetBalanceResponse.builder()
                .credit(rs.getDouble("Credit"))
                .debit(rs.getDouble("Debit"))
                .build();
    }

    public static GetCustomersResponse getCustomersFromResultSet(ResultSet resultSet)
            throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name"));
            Customer customer = new Customer(resultSet.getInt("Customer_Id"), resultSet.getString(
                    "Name"),
                    resultSet.getDouble("Amount"));
            customerList.add(customer);
        }
        return GetCustomersResponse.builder().customers(customerList).build();
    }

    public static GetTransactionsResponse getTransactionsFromResultSet(ResultSet rs)
            throws SQLException {
        List<Transaction> transactionList = new ArrayList<>();
        while (rs.next()) {
//            System.out.println(rs.getString("Description"));
            Transaction transaction = new Transaction(rs.getDate("Date"), rs.getDouble(
                    "Amount"), rs.getString("Type"), rs.getString("Description"));
            transactionList.add(transaction);
        }
        // System.out.println(transactionList.size());
        return GetTransactionsResponse.builder().transactions(transactionList).build();
    }
}

