package com.manisha.khatabook.dao.impl;

import com.manisha.khatabook.dao.KhatabookDao;
import com.manisha.khatabook.dao.constants.UserQuery;
import com.manisha.khatabook.dao.exceptions.KhatabookListOfUserDaoException;
import com.manisha.khatabook.dao.models.request.GetBalanceRequest;
import com.manisha.khatabook.dao.models.request.GetKhatabooksRequest;
import com.manisha.khatabook.dao.models.response.GetBalanceResponse;
import com.manisha.khatabook.dao.models.response.GetKhatabooksResponse;
import com.manisha.khatabook.dao.utils.ConverterUtil;
import com.manisha.khatabook.dao.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhatabookDaoImpl implements KhatabookDao {
    private Connection myConn = null;

    public KhatabookDaoImpl(Connection conn) {
        this.myConn = conn;
    }

    @Override
    public GetBalanceResponse getBalance(GetBalanceRequest getBalanceRequest) throws Exception {
        try{
            PreparedStatement ps=myConn.prepareStatement(UserQuery.GET_BALANCE);
            DbUtils.updateStatementForGetBalance(ps,getBalanceRequest);
            ResultSet rs= ps.executeQuery();
            return ConverterUtil.getBalanceFromResultSet(rs);
        }catch (SQLException e){
            throw new Exception("Failed to retrieve balance.",e);
        }
    }

    @Override
    public GetKhatabooksResponse getKhatabooks(
            GetKhatabooksRequest getKhatabooksRequest)
            throws KhatabookListOfUserDaoException {
        try {
            PreparedStatement pstmt = myConn.prepareStatement(UserQuery.GET_LIST_OF_KHATABOOKS);
            DbUtils.updateStatementForGetKhatabookList(pstmt, getKhatabooksRequest);
            ResultSet rs = pstmt.executeQuery();
            return ConverterUtil.getKhatabooksFromResultSet(rs);
        } catch (SQLException e) {
            throw new KhatabookListOfUserDaoException("Failed to retrieve khatabooks.",e);
        }
    }


}
