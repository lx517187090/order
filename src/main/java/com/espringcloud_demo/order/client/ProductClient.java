package com.espringcloud_demo.order.client;

import com.espringcloud_demo.order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

	@GetMapping("/server/msg")
	String productMsg();

	@PostMapping("/product/listForOrder")
	public List<ProductInfo> listForOrder(@RequestBody List<String> productList);

}
