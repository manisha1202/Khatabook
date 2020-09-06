package com.manisha.khatabook.dao.impl;

import com.manisha.khatabook.dao.UserAuthDao;
import com.manisha.khatabook.dao.constants.UserQuery;
import com.manisha.khatabook.dao.exceptions.KhatabookUserAuthDaoException;
import com.manisha.khatabook.dao.models.request.GetUserRequest;
import com.manisha.khatabook.dao.models.request.SaveUserRequest;
import com.manisha.khatabook.dao.models.response.GetUserResponse;
import com.manisha.khatabook.dao.utils.ConverterUtil;
import com.manisha.khatabook.dao.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthDaoImpl implements UserAuthDao {

    private Connection dbConn;

    public UserAuthDaoImpl(Connection connection) {
        this.dbConn = connection;
    }

    @Override
    public void saveUser(SaveUserRequest saveUserRequest) throws KhatabookUserAuthDaoException {
        try {
            PreparedStatement preparedStmt = dbConn.prepareStatement(UserQuery.INSERT_USER);
            DbUtils.updateStatementForSaveUser(preparedStmt, saveUserRequest);
            preparedStmt.executeUpdate();
            dbConn.close();
            System.out.println("register");
        } catch (SQLException e) {
            throw new KhatabookUserAuthDaoException("Failed to save user.", e);
        }
    }

    @Override
    public GetUserResponse getUser(GetUserRequest getUserRequest)
            throws KhatabookUserAuthDaoException {
        try {
            PreparedStatement pstmt = dbConn.prepareStatement(UserQuery.GET_USER);
            DbUtils.updateStatementForGetUser(pstmt, getUserRequest);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return ConverterUtil.GetUserResponseFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new KhatabookUserAuthDaoException("Failed to get user.", e);
        }
        return null;
    }
}
