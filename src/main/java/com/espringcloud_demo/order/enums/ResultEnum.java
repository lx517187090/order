package com.espringcloud_demo.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

	PARAM_ERROR(1, "参数错误"),
	CART_EMPTY(2, "购物车为空")
	;

	private int code;
	private String msg;

	ResultEnum(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
}
