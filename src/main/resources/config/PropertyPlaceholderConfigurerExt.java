package config;


import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class PropertyPlaceholderConfigurerExt extends PropertyPlaceholderConfigurer{


	public static String URL="http://www.tzpay.cn";
	public static String URL_WEIXIN="http://weixin.tzpay.cn";
	public static String NAME="台付通";

	
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException { 
		
		props.setProperty("url_weixin","jdbc:mysql://tzpay7688550.mysql.rds.aliyuncs.com:3307/weixin?useUnicode=true&amp;characterEncoding=utf8&amp;useOldAliasMetadataBehavior=true");
		props.setProperty("username","weixin");
		props.setProperty("password","weixin7688550");

		super.processProperties(beanFactory, props); 
	}

}
