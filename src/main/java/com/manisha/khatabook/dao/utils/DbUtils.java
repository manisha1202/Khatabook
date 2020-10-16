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
            ps.setDouble(3, addCustomerRequest.getAmount());
            ps.setInt(4, addCustomerRequest.getKhatabookId());
            ps.setString(5, addCustomerRequest.getType());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to add customer.", e);
        }
    }

    public static void updateStatementForGetCustomers(PreparedStatement ps,
                                                      GetCustomersRequest getCustomersRequest) {
        try {
            ps.setInt(1, getCustomersRequest.getKhatabookId());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to set khatabook id for get customers.", e);
        }
    }

    public static void updateStatementForGetBalance(PreparedStatement ps,
                                                    GetBalanceRequest getBalanceRequest) {
        try {
            ps.setInt(1, getBalanceRequest.getKhatabookId());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to get balance.", e);
        }
    }

    public static void updateStatementForSaveTransaction(PreparedStatement ps,
                                                         AddTransactionRequest addTransactionRequest) {
        try {
            ps.setDate(1, new java.sql.Date(addTransactionRequest.getDate().getTime()));
            ps.setDouble(2, addTransactionRequest.getAmount());
            ps.setString(3, addTransactionRequest.getType());
            ps.setString(4, addTransactionRequest.getDescription());
            ps.setInt(5, addTransactionRequest.getCustomerId());
            ps.setInt(6, addTransactionRequest.getKhatabookId());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to add te transaction.", e);
        }
    }

    public static void updateStatementForGetCustomerAmountType(PreparedStatement psca,
                                                               AddTransactionRequest addTransactionRequest) {
        try {
            psca.setInt(1, addTransactionRequest.getCustomerId());
            psca.setInt(2, addTransactionRequest.getKhatabookId());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to get customer balance.", e);
        }
    }

    public static void updateStatementForGetKhatabookTypeBalance(PreparedStatement psck, int id) {
        try {
            psck.setInt(1, id);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to get khatabook type balance.", e);
        }
    }

    public static void updateStatementForSetCustomerAmountType(PreparedStatement psc, int id,
                                                               double amount, String type) {
        try {
            psc.setDouble(1, amount);
            psc.setString(2, type);
            psc.setInt(3, id);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to set customer amount type.", e);
        }
    }

    public static void updateStatementForSetKhatabookTypeBalance(PreparedStatement psk, int id,
                                                                 double credit, double debit) {
        try {
            psk.setDouble(1, credit);
            psk.setDouble(2, debit);
            psk.setInt(3, id);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to set khatabook type balance.", e);
        }
    }

    public static void updateStatementForSaveKhatabook(PreparedStatement ps,
                                                       AddKhatabookRequest addKhatabookRequest) {
        System.out.println("khatabook name: " + addKhatabookRequest.getKhatabookName());
        try {
            ps.setString(1, addKhatabookRequest.getKhatabookName());
            ps.setString(2, addKhatabookRequest.getUserPhoneNumber());
            ps.setDouble(3, addKhatabookRequest.getCredit());
            ps.setDouble(4, addKhatabookRequest.getDebit());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to set khatabook information.", e);
        }
    }

    public static void updateStatementForGetTransactions(PreparedStatement ps,
                                                         GetTransactionsRequest getTransactionsRequest) {
        try {
            ps.setInt(1, getTransactionsRequest.getCustomerId());
            ps.setInt(2, getTransactionsRequest.getKhatabookId());
        } catch (SQLException e) {
            throw new IllegalArgumentException("Failed to get transaction list.", e);
        }
    }
}
