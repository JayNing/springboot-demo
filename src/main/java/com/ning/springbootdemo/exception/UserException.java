package com.ning.springbootdemo.exception;

public class UserException extends BizException {

    private static final long serialVersionUID = 1L;

    public UserException() {

    }

    @Override
    public UserException newInstance (String msgFormat, Object... args) {
        return new UserException(this.code, msgFormat, args);
    }

    public UserException(int code, String msg) {
        super(code, msg);
    }

    public UserException(int code, String msgFormat, Object[] args) {
        super(code, msgFormat, args);
    }

    //test
    public static final UserException TEST = new UserException(101,"test exception");
}