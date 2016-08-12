package com.longge.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;


/**
 * @author Longge
 */

public class RequestUtil {

	static Logger log=Logger.getLogger(RequestUtil.class);
	/**
	 *返回一个上文的url
	 * */
	public static String getReferer(HttpServletRequest request){
		return request.getHeader("Referer");
	}
	
	/**
	 *返回一个上文的url,并去掉域名和项目名
	 * */
	public static String getLocalReferer(HttpServletRequest request){
		String url=RequestUtil.getReferer(request);
		return url.replaceAll((request.getScheme()+"://"+request.getServerName()+request.getContextPath()).trim(), "");
	}

	/**
	 *返回一个上文的url,并去掉域名和项目名将字符串编码转换为GBK
	 * */
	public static String getLocalRefererGBK(HttpServletRequest request){
		String url=RequestUtil.getReferer(request);
		return url.replaceAll((request.getScheme()+"://"+request.getServerName()+request.getContextPath()).trim(), "");
		
	}

	/**
	 * 返回一个本页面(当前页面)带参数的url
	 * */
	public static String getReUrl(HttpServletRequest request){
		String url=request.getRequestURI(); 
		if(request.getQueryString()!=null) 
		url+="?"+request.getQueryString(); 
		return url;
	}
	
	/**
	 * 返回一个本页面(当前页面)带参数的url,<br>
	 * 并去掉request.getContextPath()项目名称
	 * */
	public static String getLocalReUrl(HttpServletRequest request){
		return getReUrl(request).replaceAll(request.getContextPath(), "");
	}
		
	/**
	 * 封装了request.getParameter(String args)<br>
	 * 并捕捉异常，防止异常抛出<br>
	 * @param request
	 * @param key 参数名称
	 * @return String
	 * @throws NullPointerException 抛出返回 ""  <br>
	 * 
	 */
	public static String getParameter(String key, HttpServletRequest request){
		try{
			String value=request.getParameter(key).trim();
			return value;
		}catch(NullPointerException e){
			return "";
		}
	}
	
	/**
	 * 封装了request.getParameter(String args)<br>
	 * 并捕捉异常，防止异常抛出<br>	 * 
	 * @param request
	 * @param key 参数名称
	 * @return String
	 * @throws NullPointerException  抛出返回: ""  <br>
	 * @throws UnsupportedEncodingException 抛出返回: ""  <br>
	 */
	public static String getParameterGBK(String key, HttpServletRequest request){
		try{
			String value=request.getParameter(key).trim();
			value=new String(value.getBytes("ISO-8859-1"),"GBK");
			return value;
		}catch(NullPointerException e){
			return "";
		}catch(UnsupportedEncodingException ue){
			return "";
		}
	}
	
	/**
	 * 封装了request.getParameter(String args)<br>
	 * 并捕捉异常，防止异常抛出<br>
	 * 把value转成数字，并捕捉是否是数字异常<br>
	 * @param request
	 * @param key 参数名称
	 * @return int
	 * @throws NumberFormatException 抛出返回: 0
	 */
	public static int getParameterNumberFormat(String key, HttpServletRequest request){
		try{
			int value=Integer.parseInt(RequestUtil.getParameter(key, request));
			return value;
		}catch(NumberFormatException e){
			return 0; 
		}
	}
	
	/**
	 * 封装了request.getParameter(String args)<br>
	 * 并捕捉异常，防止异常抛出<br>
	 * 把value转成Double，并捕捉是否是数字异常<br>
	 * @param request
	 * @param key 参数名称
	 * @return int
	 * @throws NumberFormatException 抛出返回: 0
	 */
	public static double getParameterDoubleFormat(String key, HttpServletRequest request){
		try{
			Double value=Double.parseDouble(RequestUtil.getParameter(key, request));
			if(value!=null){
				return value;
			}else{
				return 0.00;
			}
		}catch(Exception e){
			return 0.00; 
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	}

}
