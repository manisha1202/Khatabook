package com.manisha.khatabook.dao;

import com.manisha.khatabook.dao.exceptions.KhatabookUserAuthDaoException;
import com.manisha.khatabook.models.User;

public interface UserAuthDao {

    void saveUser(User user) throws KhatabookUserAuthDaoException;
    User getUser(User user) throws KhatabookUserAuthDaoException;
}
