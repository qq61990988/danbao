package com.longge.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.danbao.bean.PhoneCheckBean;
import com.danbao.bean.UserBean;
import com.danbao.service.PhoneCheckService;
import com.danbao.service.UserService;


public class CookieFilter implements Filter {
	
	private ServletContext servletContext;

	Logger log=Logger.getLogger(this.getClass());
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

		PhoneCheckService pcs=(PhoneCheckService)ctx.getBean("phoneCheckService");
		UserService userService=(UserService)ctx.getBean("userService");
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)rep;

		String cookie_agent=request.getHeader("user-agent");
		
		this.setParamId(request, response);//设置cookie，跟踪客户来源，代理或分销商
				
		Map cookieMap=CookieUtil.ReadCookieMap(request);
		if(cookieMap.get("key")!=null){//用户第一次访问，或cookie过期需要重新验证，并且绑定手机
			//若key存在 而信息不全会出现空指针 		
//			System.out.println("Cookies不为空");
//			System.out.println(cookie_agent);
			String cookie_userid=(String)cookieMap.get("userId");			
			//String cookie_superid=(String)cookieMap.get("superId");			
			//String cookie_agentid=(String)cookieMap.get("agentId");
			
			String key_md5=Md5.Md5plain(cookie_agent)+Md5.Md5plain(cookie_userid);
//			System.out.println("即时生成的加密信息："+key_md5);
//			System.out.println("原先保存的加密信息："+cookieMap.get("key"));
			
			if(cookieMap.get("key").equals(key_md5)||cookieMap.get("key")==key_md5){
			
		
				PhoneCheckBean pc=(PhoneCheckBean)pcs.selectByUserId(Integer.parseInt(cookie_userid));
				
				if(pc!=null){
					
					if(pc.getEncryptCode().equals(key_md5)||pc.getEncryptCode()==key_md5){//第二步主要验证是否和上一次登录的同一台手机，如果在另一台手机发生过登录，这里校验不会通过
						//Cookie信息验证通过，重新更新cookie日期 
						
						CookieUtil.addCookie(response, "key", cookieMap.get("key").toString(), 3600*24*30);
						CookieUtil.addCookie(response, "userId", cookie_userid, 3600*24*30);	

						//根据tel查询user表  session更新user信息 暂时模拟
						UserBean user = (UserBean)userService.selectById(Integer.parseInt(cookie_userid));
					
						request.getSession().setAttribute("user", user);
						
					}else {
						if(request.getSession().getAttribute("user")!=null){//个人用户
							request.getSession().removeAttribute("user");
						}							
					}
				}
			}			
		}
		chain.doFilter(request, response); 
		//cookies不存在  需要重新绑定
		//1.查询phonecheck表是否曾经手机登陆过   Y：更新表加密信息 ，然后查询user表是否注册过PC端（暂略）。
		//2.首次手机登陆   保存phonecheck信息  需要直接注册user表信息（如果直接添加注册  之后可用短信验证码登陆）
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.setServletContext(arg0.getServletContext());
	}

	private void setParamId(HttpServletRequest request,HttpServletResponse response){

		String openId=RequestUtil.getParameter("openid", request);
		String agentId=RequestUtil.getParameter("agentid", request);
		String superId=RequestUtil.getParameter("superid", request);
		
		if(openId.length()>0){
			CookieUtil.addCookie(response, "openId", openId, 3600*24*30);
		}
		if(agentId.length()>0){
			CookieUtil.addCookie(response, "agentId", agentId, 3600*24*30);
		}
		if(superId.length()>0){
			CookieUtil.addCookie(response, "superId", superId, 3600*24*30);
		}
	}

	
	//获取客户端的信息    
	private String getPhoneType(HttpServletRequest request){		
		
		String user_agent=request.getHeader("user-agent").toLowerCase();
		
		if(user_agent.indexOf("ipad")>0){
			return "ipad";
		}
		if(user_agent.indexOf("iphone")>0){
			return "iphone";
		}
		if(user_agent.indexOf("android")>0){
			return "android";
		}

		if(user_agent.indexOf("windows phone")>0){
			return "windows phone";
		}
		
		return "PC";
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
