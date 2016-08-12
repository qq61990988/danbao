package com.danbao.bean;

import com.danbao.service.UserService;
import com.longge.util.Base64;

public class UserinfoBean extends AbstractBean{

	
	public Integer id;
	public String name;
	public String cardId;
	public Float extractFee;
	public Float stillFee;
	public Float takeFee;
	public Float takeinFee;
	public String enableArray;
	public String channelArray;
	public Integer accountFee;
	public Integer userId;
	
	
	//内部类设置的参数
	private boolean enableRecharge;//充值
	private boolean enableCollect;//收款
	private boolean enableExtract1;//
	private boolean enableExtract0;
	private boolean enableIn;//担保收款
	private boolean enableOut;//担保付款
	
	
	private boolean alipay;
	private boolean weixinpay;
	private boolean unionpay;
	private boolean yoyipay;
	private boolean baifubao;
	
	
	public void setEnable(){
		new AnalyzeArray().setEnable();
	}
	
	public void setPay(){
		new AnalyzeArray().setPay();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserinfoBean ub=new UserinfoBean();
		ub.setEnableArray("101010");
		ub.setEnable();
		System.out.println(ub.isEnableRecharge());
		System.out.println(ub.isEnableCollect());
		System.out.println(ub.isEnableExtract1());
		System.out.println(ub.isEnableExtract0());
		System.out.println(ub.isEnableIn());
		System.out.println(ub.isEnableOut());
		
	}
	
	
	private class AnalyzeArray{
	
		private void setEnable(){

			char[] enableArray=getEnableArray().toCharArray();
			
			if(enableArray[0]=='1'){
				setEnableRecharge(true);
			}
			if(enableArray[1]=='1'){
				setEnableCollect(true);		
			}
			if(enableArray[2]=='1'){
				setEnableExtract1(true);
			}
			if(enableArray[3]=='1'){
				setEnableExtract0(true);
			}
			if(enableArray[4]=='1'){
				setEnableIn(true);
			}
			if(enableArray[5]=='1'){
				setEnableOut(true);
			}
		}
		
		private void setPay(){


			char[] channelArray=getEnableArray().toCharArray();
			
			if(channelArray[0]=='1'){
				setAlipay(true);
			}
			if(channelArray[1]=='1'){
				setWeixinpay(true);		
			}
			if(channelArray[2]=='1'){
				setUnionpay(true);
			}
			if(channelArray[3]=='1'){
				setYoyipay(true);
			}
			if(channelArray[4]=='1'){
				setBaifubao(true);
			}
		}
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Float getExtractFee() {
		return extractFee;
	}
	public void setExtractFee(Float extractFee) {
		this.extractFee = extractFee;
	}
	public Float getStillFee() {
		return stillFee;
	}
	public void setStillFee(Float stillFee) {
		this.stillFee = stillFee;
	}
	public Float getTakeFee() {
		return takeFee;
	}
	public void setTakeFee(Float takeFee) {
		this.takeFee = takeFee;
	}
	public Float getTakeinFee() {
		return takeinFee;
	}
	public void setTakeinFee(Float takeinFee) {
		this.takeinFee = takeinFee;
	}

	public Integer getAccountFee() {
		return accountFee;
	}
	public void setAccountFee(Integer accountFee) {
		this.accountFee = accountFee;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEnableArray() {
		return enableArray;
	}
	public void setEnableArray(String enableArray) {
		this.enableArray = enableArray;
	}
	public String getChannelArray() {
		return channelArray;
	}
	public void setChannelArray(String channelArray) {
		this.channelArray = channelArray;
	}

	public boolean isEnableRecharge() {
		return enableRecharge;
	}

	public void setEnableRecharge(boolean enableRecharge) {
		this.enableRecharge = enableRecharge;
	}

	public boolean isEnableCollect() {
		return enableCollect;
	}

	public void setEnableCollect(boolean enableCollect) {
		this.enableCollect = enableCollect;
	}

	public boolean isEnableExtract1() {
		return enableExtract1;
	}

	public void setEnableExtract1(boolean enableExtract1) {
		this.enableExtract1 = enableExtract1;
	}

	public boolean isEnableExtract0() {
		return enableExtract0;
	}

	public void setEnableExtract0(boolean enableExtract0) {
		this.enableExtract0 = enableExtract0;
	}

	public boolean isEnableIn() {
		return enableIn;
	}

	public void setEnableIn(boolean enableIn) {
		this.enableIn = enableIn;
	}

	public boolean isEnableOut() {
		return enableOut;
	}

	public void setEnableOut(boolean enableOut) {
		this.enableOut = enableOut;
	}

	public boolean isAlipay() {
		return alipay;
	}

	public void setAlipay(boolean alipay) {
		this.alipay = alipay;
	}

	public boolean isWeixinpay() {
		return weixinpay;
	}

	public void setWeixinpay(boolean weixinpay) {
		this.weixinpay = weixinpay;
	}

	public boolean isUnionpay() {
		return unionpay;
	}

	public void setUnionpay(boolean unionpay) {
		this.unionpay = unionpay;
	}

	public boolean isYoyipay() {
		return yoyipay;
	}

	public void setYoyipay(boolean yoyipay) {
		this.yoyipay = yoyipay;
	}

	public boolean isBaifubao() {
		return baifubao;
	}

	public void setBaifubao(boolean baifubao) {
		this.baifubao = baifubao;
	}
}
