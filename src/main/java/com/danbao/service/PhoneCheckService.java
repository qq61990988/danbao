package com.danbao.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danbao.bean.AbstractBean;

@Service("phoneCheckService")
@Transactional
public class PhoneCheckService extends AbstractService {

	@Override
	public boolean insert(AbstractBean bean) {
		// TODO Auto-generated method stub
		
		int result=this.getPhoneCheckDao().insertPhoneCheck(bean);

		if(result==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public AbstractBean selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectList(Map map) {
		// TODO Auto-generated method stub
		
		return null;
		
	}
	
	public AbstractBean selectByUserId(int userId){
		
		
		return this.getPhoneCheckDao().selectPhoneCheckByUserId(userId);
	}

	@Override
	public boolean update(AbstractBean bean) {
		// TODO Auto-generated method stub
		int result=this.getPhoneCheckDao().updatePhoneCheck(bean);
		
		if(result==0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
