package com.weixin.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.sword.wechat4j.message.TemplateMsg;
import org.sword.wechat4j.message.template.TemplateMsgBody;
import org.sword.wechat4j.message.template.TemplateMsgData;

public class TemplateMsgUtil {//充值成功通知消息

	public String payTemp(String orderMoney, String balance){

		TemplateMsg msg=new TemplateMsg();
		
		TemplateMsgBody body=new TemplateMsgBody();
		body.setTemplateId("Bhz7zf90t43jpk0aBnrGsD6Uh9C_pGgUVgLI5C9HUzk");
		body.setTouser("openid");
		//body.setUrl(msg.SEND_MSG_URL);

		List listData=new ArrayList();
		
		TemplateMsgData data_first=new TemplateMsgData();
		data_first.setName("first");
		data_first.setValue("您已充值成功");
		listData.add(data_first);

		TemplateMsgData data_keyword1=new TemplateMsgData();
		data_keyword1.setName("keyword1");
		data_keyword1.setValue(orderMoney+"元");
		listData.add(data_keyword1);

		TemplateMsgData data_keyword2=new TemplateMsgData();
		data_keyword2.setName("keyword2");
		Calendar date = new GregorianCalendar();//时间
		data_keyword2.setValue(date.getTime().toLocaleString());
		listData.add(data_keyword2);

		TemplateMsgData data_keyword3=new TemplateMsgData();
		data_keyword3.setName("keyword3");
		data_keyword3.setValue(balance+"元");
		listData.add(data_keyword3);

		TemplateMsgData data_remark=new TemplateMsgData();
		data_remark.setName("remark");
		data_remark.setValue("如有疑问，请联系客服");
		listData.add(data_remark);
		
		body.setData(listData);

		 return msg.send(body);		
	}
	
	
}
