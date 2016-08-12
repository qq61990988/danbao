package com.danbao.bean;

import java.util.Date;


public class UserBean extends AbstractEncryptBean {
	
	//用户信息表
	public Integer id;
	public String tel;
	public String password;
	public String payPassword;
	public Date registerDateTime;
	public Long timesTamp;
	public Integer status;
	public Integer atStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public Date getRegisterDateTime() {
		return registerDateTime;
	}
	public void setRegisterDateTime(Date registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	public Long getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAtStatus() {
		return atStatus;
	}
	public void setAtStatus(Integer atStatus) {
		this.atStatus = atStatus;
	}
		
}
