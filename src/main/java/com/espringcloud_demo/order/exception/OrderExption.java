package com.espringcloud_demo.order.exception;

import com.espringcloud_demo.order.enums.ResultEnum;

public class OrderExption extends RuntimeException {

	private Integer code;

	public OrderExption(Integer code, String msg){
		super(msg);
		this.code = code;
	}

	public OrderExption(ResultEnum resultEnum){
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
}
