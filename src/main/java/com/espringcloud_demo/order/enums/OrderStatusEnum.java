package com.espringcloud_demo.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

	NEW(0, "新订单"),
	FINISHED(1, "完成"),
	CANCEL(2, "取消");

	private int code;
	private String msg;

	OrderStatusEnum(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
}
