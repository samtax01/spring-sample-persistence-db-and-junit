package com.example.unit_test_sample.utils;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.Optional;


@Builder
@Data
public
class ResultStatus {
    private Object object;
    private String message;
    private boolean status;
    private int code;

    public static ResultStatus make(Object object, String message, boolean status, int code){
        return new ResultStatus(object, message, status,code);
    }

    public static ResultStatus byNull(Object object, String trueMessage, String falseMessage){
        boolean isFalse =   Objects.isNull(object) || Objects.equals(object, "") || object.equals(false);
        return new ResultStatus(
                object,
                isFalse? falseMessage: trueMessage,
                !isFalse,
                isFalse? 500: 200
        );
    }
}
