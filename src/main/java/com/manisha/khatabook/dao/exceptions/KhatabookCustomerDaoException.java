package com.manisha.khatabook.dao.exceptions;

public class KhatabookCustomerDaoException extends Exception {

    public KhatabookCustomerDaoException(String msg) {
        super(msg);
    }

    public KhatabookCustomerDaoException(String msg, Throwable e) {
        super(msg, e);
    }
}
