package com.manisha.khatabook.dao.exceptions;

public class KhatabookUserAuthDaoException extends Exception{

    public KhatabookUserAuthDaoException(String msg){
        super(msg);
    }
    public KhatabookUserAuthDaoException(String msg, Throwable t){
        super(msg,t);
    }
}
