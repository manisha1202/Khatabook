package com.manisha.khatabook.dao.impl;

import com.manisha.khatabook.dao.CustomerDao;
import com.manisha.khatabook.dao.constants.UserQuery;
import com.manisha.khatabook.dao.exceptions.KhatabookCustomerDaoException;
import com.manisha.khatabook.dao.models.request.AddCustomerRequest;
import com.manisha.khatabook.dao.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    private Connection dbConn;

    public CustomerDaoImpl(Connection connection) {
        this.dbConn = connection;
    }

    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest)
            throws KhatabookCustomerDaoException {
        try {
            PreparedStatement preparedStmt = dbConn.prepareStatement(UserQuery.INSERT_CUSTOMER);
            DbUtils.updateStatementForAddCustomer(preparedStmt, addCustomerRequest);
            preparedStmt.executeUpdate();
            dbConn.close();
            System.out.println("added");
        } catch (SQLException e) {
            throw new KhatabookCustomerDaoException("Failed to add customer.", e);
        }
    }
}
