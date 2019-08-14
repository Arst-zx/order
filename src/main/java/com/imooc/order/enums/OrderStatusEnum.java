package com.imooc.order.enums;

import lombok.Getter;

/**
 * @author 章鑫
 * @date 2018/8/27 10:08
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
