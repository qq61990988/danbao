package com.danbao.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.danbao.bean.AbstractBean;
import com.danbao.bean.OrderRecordBean;
import com.danbao.dao.PhoneCheckDao;
import com.danbao.dao.UserDao;

public abstract class AbstractService implements RelaceInterface{

	@Resource
	private UserDao userDao;
	
	@Resource
	private PhoneCheckDao phoneCheckDao;
	

	/**
	 * 保存数据
	 * @param obj
	 */
	public abstract boolean insert(AbstractBean bean);
	
	public abstract boolean update(AbstractBean bean);
	
	public abstract AbstractBean selectById(int id);
	
	public abstract List selectList(Map map);

	
	/**
	 * 订单类型编码转换成订单名称
	 * 1转成充值
	 */
	public OrderRecordBean replaceOrderType(OrderRecordBean bean){
		
		switch(bean.getOrderType()){

			case 1:bean.setOrderName("账户充值"); break;
	
			case 2:bean.setOrderName("收款"); 	break;
	
			case 3:bean.setOrderName("T+1提现"); break;
			
			case 4:bean.setOrderName("D+0提现"); break;
			
			case 5:bean.setOrderName("担保收款"); break;
			
			case 6:bean.setOrderName("担保付款"); break;
			
			case 7:bean.setOrderName("还款"); 	break;
			
			case 8:bean.setOrderName("消费"); 	break;
			
			case 9:bean.setOrderName("手续费"); 	break;

		}
		
		return bean;
	}
	
	public AbstractBean replaceSecuredType(AbstractBean bean){

		
		
		
		return bean;
	}
	public AbstractBean replaceBank(AbstractBean bean){

		return bean;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PhoneCheckDao getPhoneCheckDao() {
		return phoneCheckDao;
	}

	public void setPhoneCheckDao(PhoneCheckDao phoneCheckDao) {
		this.phoneCheckDao = phoneCheckDao;
	}
}
