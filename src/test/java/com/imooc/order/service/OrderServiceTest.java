package com.imooc.order.service;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.converter.OrderForm2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.form.OrderForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 章鑫
 * @Date 2018/9/4 17:23
 */
@Component
public class OrderServiceTest extends OrderApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {

        OrderForm orderForm = new OrderForm();

        orderForm.setOpenid("1111111111");
        orderForm.setAddress("联通大楼");
        orderForm.setName("章鑫");
        orderForm.setPhone("18611881899");
        orderForm.setItems("[{\"productId\":\"157875196366190023\",\"productQuantity\":2}]");

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        orderService.create(orderDTO);
    }
}