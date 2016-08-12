package com.danbao.dao;

import java.util.List;

import com.danbao.bean.AbstractBean;

public interface PhoneCheckDao {

	public int insertPhoneCheck(AbstractBean bean);
	public int updatePhoneCheck(AbstractBean bean);
	public AbstractBean selectPhoneCheckByUserId(Integer userId);
}
