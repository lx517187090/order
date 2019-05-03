package com.espringcloud_demo.order.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ProductInfo {
	@Id
	private String productId;

	private String productName;

	private BigDecimal productPrice;

	/**
	 *
	 */
	private int productStock;

	private String productDescription;

	private String productIcon;

	private int productStatus;

	private int categoryType;

	private Date createTime;

	private Date updateTime;
}
