package com.imooc.order.dto;

import com.imooc.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 章鑫
 * @date 2018/8/27 15:26
 */
@Data
public class OrderDTO {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     *  订单状态，默认为新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认未支付
     */
    private Integer payStatus;

    /**
     * 订单详情
     */
    private List<OrderDetail> orderDetailList;
}
