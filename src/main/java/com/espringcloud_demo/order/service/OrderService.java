package com.espringcloud_demo.order.service;

import com.espringcloud_demo.order.dao.OrderMasterRepository;
import com.espringcloud_demo.order.dto.OrderDTO;
import com.espringcloud_demo.order.entity.OrderMaster;
import com.espringcloud_demo.order.enums.OrderStatusEnum;
import com.espringcloud_demo.order.enums.PayStatusEnum;
import com.espringcloud_demo.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("orderService")
public class OrderService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Autowired
	private OrderDetailService orderDetailService;

	/**
	 * 1参数校验
	 * 2 TODO 查询商品信息
	 * 3 TODO 计算总价
	 * 4 TODO 扣库存
	 * 5订单入库
	 */
	public OrderDTO create(OrderDTO orderDTO){
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(KeyUtil.genUniqueKey());
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(new BigDecimal(10));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setOrderStatus(PayStatusEnum.WAIT.getCode());

		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}

}
