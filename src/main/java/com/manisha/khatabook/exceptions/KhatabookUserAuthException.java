package com.manisha.khatabook.exceptions;

public class KhatabookUserAuthException extends Exception {

    public KhatabookUserAuthException(String msg) {
        super(msg);
    }

    public KhatabookUserAuthException(String msg, Throwable e) {
        super(msg, e);
    }
}
