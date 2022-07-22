package com.imooc.order.VO;

import lombok.Data;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: ResultVO
 * @Create: 2018-08-29 15:14
 * @Description:
 **/
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
