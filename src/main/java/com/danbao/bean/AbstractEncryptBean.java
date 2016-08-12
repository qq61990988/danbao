package com.danbao.bean;

public abstract class AbstractEncryptBean extends AbstractBean{

	public String Encrypt;
	public String Security;
	
	public String getEncrypt() {
		return Encrypt;
	}
	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}
	public String getSecurity() {
		return Security;
	}
	public void setSecurity(String security) {
		Security = security;
	}
}
