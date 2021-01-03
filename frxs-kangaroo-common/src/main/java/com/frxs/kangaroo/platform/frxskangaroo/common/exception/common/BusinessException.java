package com.frxs.kangaroo.platform.frxskangaroo.common.exception.common;

import lombok.Data;

@Data
public class BusinessException extends Throwable  {

    private Throwable  exception;
    private String Massage;

    public BusinessException(Throwable exception, String massage) {
        this.exception = exception;
        Massage = massage;
    }
}
