package com.manisha.khatabook.dao.exceptions;

public class KhatabookListOfUserDaoException extends Exception {
    public KhatabookListOfUserDaoException(String msg) {
        super(msg);
    }

    public KhatabookListOfUserDaoException(String msg, Throwable t) {
        super(msg, t);
    }
}
