package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookListOfUserDaoException;
import com.manisha.khatabook.dao.models.request.GetKhatabookListOfUserRequest;
import com.manisha.khatabook.dao.models.response.GetKhatabookListOfUserResponse;

public interface KhatabookDao {
    GetKhatabookListOfUserResponse getKhatabooksForAUser(
            GetKhatabookListOfUserRequest getKhatabookListOfUserRequest)
            throws KhatabookListOfUserDaoException;

}
