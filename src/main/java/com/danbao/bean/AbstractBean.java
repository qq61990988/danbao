package com.danbao.bean;

import java.util.Date;

public abstract class AbstractBean {

	public Integer id;
	
	
	/*//浏览器信息存储、校验、记录表
	//public Integer id;
	public String encryptCode;
	public String openId;
	public Integer agentId;
	public Integer superId;
	public Integer userId;*/
	
	
	//代付商信息表
	//public Integer id;
	public String name;
	public String userame;
	public String password;
	public String methodType;
	
	//用户信息表
	/*//public Integer id;
	public String tel;
	//public String password;
	public String payPassword;
	public Date registerDateTime;
	public Long timesTamp;
	public Integer status;
	public Integer atStatus;*/
	
	/*//用户详细信息表
	//public Integer id;
	public String name;
	public String cardId;
	public Float extractFee;
	public Float stillFee;
	public Float takeFee;
	public Float takeinFee;
	public Integer enableRecharge;
	public Integer enableCollect;
	public Integer enableExtract1;
	public Integer enableExtract0;
	public Integer enableIn;
	public Integer enableOut;
	public String channel;
	public Integer accountFee;
	public Integer userId;*/
	
	/*//绑定储蓄卡表
	//public Integer id;	
	public String cardcode;
	public String cardno;
	public String saveDateTime;
	public String timestamp;
	public String cardStatus;
	//public String userId;
	 */	
	

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
