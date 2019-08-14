package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 章鑫
 * @date 2018/8/24 16:40
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
