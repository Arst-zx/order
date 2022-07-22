package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: OrderService
 * @Create: 2018-08-27 15:52
 * @Description:
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
