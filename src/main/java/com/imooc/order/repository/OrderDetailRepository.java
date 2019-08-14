package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 章鑫
 * @date 2018/8/24 16:41
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
