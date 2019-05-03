package com.espringcloud_demo.order.service;

import com.espringcloud_demo.order.dto.OrderDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	@Test
	public void create() {

		OrderDTO orderDTO = new OrderDTO();
		orderService.create(orderDTO);
	}
}