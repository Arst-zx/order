package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

/**
 * 2017-12-10 17:27
 * @author 章鑫
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
