package com.imooc.order.VO;

/**
 * @Author 章鑫
 * @Date 2018/8/29 15:14
 */

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
