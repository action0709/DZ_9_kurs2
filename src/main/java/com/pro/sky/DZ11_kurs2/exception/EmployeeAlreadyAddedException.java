package com.pro.sky.DZ11_kurs2.exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}



