package com.danbao.service;

import com.danbao.bean.AbstractBean;
import com.danbao.bean.OrderRecordBean;

public interface RelaceInterface {

	public OrderRecordBean replaceOrderType(OrderRecordBean bean);
	public AbstractBean replaceSecuredType(AbstractBean bean);
	public AbstractBean replaceBank(AbstractBean bean);
}
