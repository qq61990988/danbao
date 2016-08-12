package com.danbao.bean;

public class CardBean extends AbstractEncryptBean {
	
	//绑定储蓄卡表
	public Integer id;	
	public String cardcode;
	public String cardno;
	public String saveDateTime;
	public String timestamp;
	public String cardStatus;
	public String userId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getSaveDateTime() {
		return saveDateTime;
	}
	public void setSaveDateTime(String saveDateTime) {
		this.saveDateTime = saveDateTime;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
