package com.espringcloud_demo.order.utils;

import java.util.Random;

public class KeyUtil {

	/**
	 * 生成唯一组件
	 * 时间戳 + 随机数
	 */
	public static synchronized String genUniqueKey(){
		Random random = new Random();
		Integer num = random.nextInt(999999) + 100000;
		return System.currentTimeMillis() + String.valueOf(num);
	}

}
