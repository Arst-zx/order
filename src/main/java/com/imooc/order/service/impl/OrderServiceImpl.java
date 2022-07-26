package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CarDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.repository.OrderDetailRepository;
import com.imooc.order.repository.OrderMasterRepository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 章鑫
 * @Project_name：order
 * @Name: OrderServiceImpl
 * @Create: 2018-08-27 16:44
 * @Description:
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        //查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList()
                                             .stream()
                                             .map(OrderDetail::getProductId)
                                             .collect(Collectors.toList());
        List<ProductInfo> productInfoList =  productClient.listForOrder(productIdList);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        //外层遍历购物车商品
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                BeanUtils.copyProperties(productInfo,orderDetail);
                orderDetail.setOrderId(orderId);
                orderDetail.setDetailId(KeyUtil.genUniqueKey());

                //订单详情入库
                orderDetailRepository.save(orderDetail);
                }
            }
        }

        //扣库存（调用商品服务）
        List<CarDTO> carDTOList = orderDTO.getOrderDetailList()
                                          .stream()
                                          .map(e -> new CarDTO(e.getProductId(),e.getProductQuantity()))
                                          .collect(Collectors.toList());

        productClient.decreaseStock(carDTOList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();

        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);

        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
