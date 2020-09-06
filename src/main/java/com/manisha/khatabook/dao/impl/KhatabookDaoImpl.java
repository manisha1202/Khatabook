package com.manisha.khatabook.dao.impl;

import com.manisha.khatabook.dao.KhatabookDao;
import com.manisha.khatabook.dao.constants.UserQuery;
import com.manisha.khatabook.dao.exceptions.KhatabookListOfUserDaoException;
import com.manisha.khatabook.dao.models.request.GetKhatabookListOfUserRequest;
import com.manisha.khatabook.dao.models.response.GetKhatabookListOfUserResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhatabookDaoImpl implements KhatabookDao {
    private Connection myConn = null;

    public KhatabookDaoImpl(Connection conn) {
        this.myConn = conn;
    }

    @Override
    public GetKhatabookListOfUserResponse getKhatabooksForAUser(
            GetKhatabookListOfUserRequest getKhatabookListOfUserRequest)
            throws KhatabookListOfUserDaoException {
        List<String> res = new ArrayList<>();
        try {
            PreparedStatement pstmt = myConn.prepareStatement(UserQuery.GET_LIST_OF_KHATABOOKS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                res.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
