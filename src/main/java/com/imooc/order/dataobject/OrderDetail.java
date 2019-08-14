package com.imooc.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 章鑫
 * @date 2018/8/24 16:31
 */
@Data
@Entity
public class OrderDetail {

    /**
     * 订单详情id
     */
    @Id
    private String detailId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品当前价格
     */
    private BigDecimal productPrice;

    /**
     * 数量
     */
    private Integer productQuantity;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 订单详情创建时间
     */
    private Date createTime;

    /**
     * 订单详情修改时间
     */
    private Date updateTime;
}
