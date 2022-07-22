package com.imooc.order.dto;

import lombok.Data;

/**
 * @Author: 章鑫
 * @Project_name：product
 * @Name: CarDTO
 * @Create: 2018-08-30 15:32
 * @Description:
 **/
@Data
public class CarDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品购买数量
     */
    private Integer productQuantity;

    public CarDTO() {

    }

    public CarDTO(String productId,Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
