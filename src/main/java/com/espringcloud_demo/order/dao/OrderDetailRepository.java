package com.espringcloud_demo.order.dao;

import com.espringcloud_demo.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {


}
