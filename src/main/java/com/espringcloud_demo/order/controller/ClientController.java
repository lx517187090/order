package com.espringcloud_demo.order.controller;

import com.espringcloud_demo.order.client.ProductClient;
import com.espringcloud_demo.order.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

	/*@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;*/

	@Autowired
	private ProductClient productClient;

	@GetMapping("/getMsg")
	public String msg(){
		// 1 直接用restTemplate
		/*RestTemplate restTemplate = new RestTemplate();
		String forObject = restTemplate.getForObject("http://localhost:8080/server/msg", String.class);*/

		//2 利用 loadBalancerClient获取host port
		/*ServiceInstance product = loadBalancerClient.choose("PRODUCT");
		String format = String.format("http://%s:%s", product.getHost(), product.getPort()) + "/server/msg";
		RestTemplate restTemplate = new RestTemplate();
		String forObject = restTemplate.getForObject(format, String.class);*/

		//3 @LoadBalanced
		//String forObject = restTemplate.getForObject("http://PRODUCT/server/msg", String.class);
		String ss = productClient.productMsg();

		return  ss + "zzz11";
	}

	@GetMapping("/getMsg2")
	public List test2(){
		List<String> productIds = Arrays.asList("157875196366160022","157875227953464068");
		List<ProductInfo> list = productClient.listForOrder(productIds);
		System.out.println(list);
		return list;
	}
}
