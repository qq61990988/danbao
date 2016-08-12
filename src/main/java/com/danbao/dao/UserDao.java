package com.danbao.dao;

import com.danbao.bean.AbstractBean;


public interface UserDao {

 
	public int insertUser(AbstractBean bean);   
	
	public int updateUser(AbstractBean bean);   
	
	public AbstractBean selectUserByTel(String tel);
}
