package com.espringcloud_demo.order.controller;

import com.espringcloud_demo.order.VO.ResultVO;
import com.espringcloud_demo.order.converter.OrderForm2OrderDTO;
import com.espringcloud_demo.order.dto.OrderDTO;
import com.espringcloud_demo.order.enums.ResultEnum;
import com.espringcloud_demo.order.exception.OrderExption;
import com.espringcloud_demo.order.form.OrderForm;
import com.espringcloud_demo.order.service.OrderService;
import com.espringcloud_demo.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {


	@Autowired
	private OrderService orderService;
	/**
	 * 1参数校验
	 * 2查询商品信息
	 * 3 计算总价
	 * 4 扣库存
	 * 5订单入库
	 */
	@PostMapping("/create")
	public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			log.error("创建订单参数不正确");
			throw new OrderExption(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		}
		//orderForm --> orderDTO
		OrderDTO orderDTO = OrderForm2OrderDTO.converter(orderForm);
		if(CollectionUtils.isEmpty(orderDTO.getOrderDetails())){
			log.error("创建订单购物车为空{");
			throw new OrderExption(ResultEnum.CART_EMPTY);
		}
		OrderDTO result = orderService.create(orderDTO);

		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("orderId", result.getOrderId());

		return ResultVOUtil.success(resultMap);
	}
}
