package com.danbao.service;

import java.util.List;

import javax.annotation.Resource;

import com.danbao.bean.AbstractEncryptBean;
import com.danbao.dao.UserDao;
import com.longge.util.Base64;
import com.longge.util.Md5;

public abstract class AbstractEncryptService extends AbstractService {


	/**
     * 封装一下Encrypt，生成加密
     * @param bean
     * @return AbstracEncryptBean 带有加密的
     */
	public AbstractEncryptBean EncryptCode(AbstractEncryptBean bean) {//MD密码
     	
     	bean.setEncrypt(Md5.Md5plain(EncryptString(bean)));
     	bean.setSecurity(Base64.encode(EncryptString(bean)));
     	
     	return bean;
     }
     
	/**
     * 校验加密
     * @param bean
     * @return true 校验通过
     */
	public Boolean Validator(AbstractEncryptBean bean){
     	return Md5.Validator(EncryptString(bean), bean.getEncrypt());
     }
     
	/**
     * 批量校验加密
     * @param list
     * @return true 校验通过
     */
	public Boolean ValidatorList(List<AbstractEncryptBean> list){
     	
     	for(int i=0; i<list.size(); i++){
     		if(!this.Validator(list.get(i))){
     			return false;
     		}
     	}
     	return true;
     }
	
	/**
     * 把对象需要加密的参数连接成字符串格式，方便加密
     * @param bean
     * @return
     */
	protected abstract String EncryptString(AbstractEncryptBean bean);


}
