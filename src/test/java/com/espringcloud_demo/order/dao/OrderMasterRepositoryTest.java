package com.espringcloud_demo.order.dao;

import com.espringcloud_demo.order.entity.OrderMaster;
import com.espringcloud_demo.order.enums.OrderStatusEnum;
import com.espringcloud_demo.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Test
	public void contextLoads() {

		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("123455");
		orderMaster.setBuyerName("kk");
		orderMaster.setBuyerPhone("18665896853");
		orderMaster.setBuyerAddress("sz");
		orderMaster.setBuyerOpenid("111112");
		orderMaster.setOrderAmount(new BigDecimal(2.5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

		OrderMaster result = orderMasterRepository.save(orderMaster);

		Assert.assertTrue(result != null);

	}
}