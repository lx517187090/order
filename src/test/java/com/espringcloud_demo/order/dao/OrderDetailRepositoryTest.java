package com.espringcloud_demo.order.dao;

import com.espringcloud_demo.order.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Test
	public void contextLoads() {

		OrderDetail orderdetail = new OrderDetail();
		orderdetail.setDetailId("122231");
		orderdetail.setOrderId("123455");
		orderdetail.setProductIcon("http://xxx.com");
		orderdetail.setProductId("157875196366160022");
		orderdetail.setProductName("皮蛋粥");
		orderdetail.setProductPrice(new BigDecimal(0.01));
		orderdetail.setProductQuantity(2);

		OrderDetail result = orderDetailRepository.save(orderdetail);

		Assert.assertTrue(result != null);

	}
}