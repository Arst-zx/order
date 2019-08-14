package com.imooc.order.enums;

import lombok.Getter;

/**
 * @author 章鑫
 * @date 2018/8/27 10:19
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code,String msg) {

        this.code = code;
        this.msg = msg;
    }
}
