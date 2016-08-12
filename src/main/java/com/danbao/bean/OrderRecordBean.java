package com.danbao.bean;

import java.util.Date;

public class OrderRecordBean extends AbstractEncryptBean{
	
	public Integer OrderType;
	public String OrderName;
	public Integer getOrderType() {
		return OrderType;
	}
	public void setOrderType(Integer orderType) {
		OrderType = orderType;
	}
	public String getOrderName() {
		return OrderName;
	}
	public void setOrderName(String orderName) {
		OrderName = orderName;
	}
	
}
