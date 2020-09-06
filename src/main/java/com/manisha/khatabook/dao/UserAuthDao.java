package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookUserAuthDaoException;
import com.manisha.khatabook.dao.models.request.GetUserRequest;
import com.manisha.khatabook.dao.models.request.SaveUserRequest;
import com.manisha.khatabook.dao.models.response.GetUserResponse;

public interface UserAuthDao {

    void saveUser(SaveUserRequest saveUserRequest) throws KhatabookUserAuthDaoException;

    GetUserResponse getUser(GetUserRequest getUserRequest) throws KhatabookUserAuthDaoException;
}
