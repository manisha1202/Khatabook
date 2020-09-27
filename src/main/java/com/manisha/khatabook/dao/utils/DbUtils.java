package com.manisha.khatabook.dao.utils;

import com.manisha.khatabook.dao.models.request.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DbUtils {
    private DbUtils() {

    }

    public static void updateStatementForSaveUser(PreparedStatement ps,
                                                  SaveUserRequest saveUserRequest) {

        try {
            ps.setString(1, saveUserRequest.getUserName());
            ps.setString(2, saveUserRequest.getPhoneNumber());
            ps.setString(3, saveUserRequest.getPassword());
            ps.setString(4, saveUserRequest.getEmail());
            ps.setString(5, saveUserRequest.getAddress());
            ps.setString(6, saveUserRequest.getImage());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to create query.", e);
        }
    }

    public static void updateStatementForGetUser(PreparedStatement ps,
                                                 GetUserRequest getUserRequest) {
        try {
            ps.setString(1, getUserRequest.getPhoneNumber());
            ps.setString(2, getUserRequest.getPassword());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to create query.", e);
        }
    }

    public static void updateStatementForGetKhatabookList(PreparedStatement ps,
                                                          GetKhatabooksRequest getKhatabooksRequest) {
        try {
            ps.setString(1, getKhatabooksRequest.getPhoneNumber());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to retreive the list of khatabooks " +
                    "for the particular user.", e);
        }
    }

    public static void updateStatementForAddCustomer(PreparedStatement ps,
                                                     AddCustomerRequest addCustomerRequest) {
        try {
            ps.setString(1, addCustomerRequest.getCustomerName());
            ps.setString(2, addCustomerRequest.getPhoneNumber());
            ps.setInt(3, addCustomerRequest.getLoanAmount());
            ps.setInt(4, addCustomerRequest.getKhatabookId());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to add customer.", e);
        }
    }

    public static void updateStatementForGetCustomers(PreparedStatement ps,
                                                      GetCustomersRequest getCustomersRequest) {
        try {
            ps.setString(1, getCustomersRequest.getKhatabookName());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to get customers.", e);
        }
    }

    public static void updateStatementForGetBalance(PreparedStatement ps,
                                                    GetBalanceRequest getBalanceRequest) {
        try{
            ps.setInt(1,getBalanceRequest.getKhatabookId());
        }catch(SQLException e){
            throw new IllegalArgumentException("Failed to get balance.",e);
        }
    }
}
