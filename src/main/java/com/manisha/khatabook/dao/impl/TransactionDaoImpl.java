package com.manisha.khatabook.dao.impl;

import com.manisha.khatabook.dao.TransactionDao;
import com.manisha.khatabook.dao.constants.UserQuery;
import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import com.manisha.khatabook.dao.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {

    private Connection myConn = null;

    public TransactionDaoImpl(Connection conn){
        this.myConn = conn;
    }
    @Override
    public void addTransaction(AddTransactionRequest addTransactionRequest) throws Exception {
        try{
            PreparedStatement ps=myConn.prepareStatement(UserQuery.ADD_TRANSACTION);
            DbUtils.updateStatementForSaveTransaction(ps, addTransactionRequest);
            ps.executeUpdate();
            //PreparedStatement psc=myConn.prepareStatement(UserQuery.UPDATE_CUSTOMER);
            //PreparedStatement psk=myConn.prepareStatement(UserQuery.UPDATE_KHATABOOK);
            System.out.println("transaction added");
        }catch (SQLException e){
            throw new Exception("Failed to add the transaction.",e);
        }

    }
}
