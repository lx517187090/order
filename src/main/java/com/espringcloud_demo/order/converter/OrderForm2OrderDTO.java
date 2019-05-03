package com.espringcloud_demo.order.converter;

import com.espringcloud_demo.order.dto.OrderDTO;
import com.espringcloud_demo.order.entity.OrderDetail;
import com.espringcloud_demo.order.enums.ResultEnum;
import com.espringcloud_demo.order.exception.OrderExption;
import com.espringcloud_demo.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTO {


	public static OrderDTO converter(OrderForm orderForm){

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerPhone(orderForm.getPhone());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());

		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			Gson gson = new Gson();
			orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
		}catch (Exception e){
			log.error("json 转换出错 string{}" , orderForm.getItems());
			throw new OrderExption(ResultEnum.PARAM_ERROR);
		}
		orderDTO.setOrderDetails(orderDetailList);
		return orderDTO;
	}
}
