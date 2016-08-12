package com.danbao.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.danbao.bean.AbstractBean;
import com.danbao.bean.AbstractEncryptBean;
import com.danbao.bean.UserBean;
import com.longge.util.Base64;

@Service("userService")
@Transactional
public class UserService extends AbstractEncryptService {


	@Transactional(propagation=Propagation.REQUIRED)
	public boolean insert(AbstractBean bean) {
		// TODO Auto-generated method stub
		
		
		int result=this.getUserDao().insertUser(this.EncryptCode((AbstractEncryptBean)bean));
		
		if(result==0){
			return false;
		}else{
			return true;
		}
		
	}
	
	public AbstractBean selectUserByTel(String tel){
		
		return this.getUserDao().selectUserByTel(tel);
				
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

	@Override
	public boolean update(AbstractBean bean) {
		// TODO Auto-generated method stub

		int result=this.getUserDao().updateUser(this.EncryptCode((AbstractEncryptBean)bean));
		
		if(result==0){
			return false;
		}else{
			return true;
		}
	}
	

	protected String EncryptString(AbstractEncryptBean bean){

		UserBean user=(UserBean)bean;
		
		
    	StringBuffer sb=new StringBuffer();
    	sb.append(user.getId());
    	sb.append(user.getTel());
    	sb.append(user.getTimesTamp());
    	sb.append(user.getStatus());
    	sb.append(user.getAtStatus());
    	
    	return sb.toString();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//注册加密解密
		UserService us=new UserService();
		AbstractEncryptBean bean=us.EncryptCode(new UserBean());
		System.out.println(bean.getEncrypt());
		System.out.println(bean.getSecurity());
		String str=Base64.decode(bean.getSecurity());
		System.out.println(str);// very good!
		
	}
	
}
