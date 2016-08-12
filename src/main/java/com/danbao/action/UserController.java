package com.danbao.action;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danbao.bean.PhoneCheckBean;
import com.danbao.bean.UserBean;
import com.danbao.service.PhoneCheckService;
import com.danbao.service.UserService;
import com.longge.util.CookieUtil;
import com.longge.util.Md5;
import com.longge.util.RequestUtil;


@Controller
@RequestMapping("/user")
public class UserController {

	Logger log=Logger.getLogger(this.getClass());
	
	@Resource
	private UserService userService;
	
	@Resource
	private PhoneCheckService phoneCheckService;
	
	//用户注册
	@RequestMapping("/register")
	public String register(HttpServletRequest request,HttpServletResponse response,Model model){
		
		String tel="18667622366";
		String code_session=(String)request.getSession().getAttribute("code");
		

		UserBean ub=new UserBean();
		ub.setTel(tel);	
		ub.setPassword(Md5.Md5plain("123456"));
		ub.setPayPassword(Md5.Md5plain("7688550"));

		Long timeMillis=System.currentTimeMillis();
		String timestamp=Long.toString(timeMillis);        
		Timestamp ts = new Timestamp(Long.parseLong(timestamp));   		
		ub.setRegisterDateTime(ts);
		
		ub.setTimesTamp(timeMillis);
		ub.setStatus(1);
		ub.setAtStatus(0);
		
		boolean b=this.getUserService().insert(ub);
		
		if(b){
			request.setAttribute("result", "注册成功");
		}else{
			request.setAttribute("result", "注册失败");
		}
		
		return "result";
	}
	
	//用户登录
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		

		JSONObject json = new JSONObject();
		
		String tel=RequestUtil.getParameter("tel", request);
		String password=RequestUtil.getParameter("password", request);

		log.info(tel);
		log.info(password);
		
		if(tel.length()!=11||password.length()<6){

			json.put("message", "登录失败:请输入正确的账户和密码！");
			model.addAttribute("result", json);
			
			return "result";
		}
		
		UserBean ub=(UserBean)this.getUserService().selectUserByTel(tel);

		if(ub!=null){
			if(Md5.Md5plain(password).equals(ub.getPassword())){
				//System.out.println("登录成功");
				json.put("result", "00");
				this.setCookie(request, response, ub.getId());//设置cookie
			}else{
				json.put("result", "01");
				json.put("message", "登录失败:账户或密码有误，请重试！");
			}
		}else{
			json.put("result", "01");
			json.put("message", "登录失败:账户或密码有误，请重试！");	
		}

		model.addAttribute("result", json);
		
		return "result";
	}
	
	//用户验证码登录
	@RequestMapping("/login_msg")
	public String login_msg(HttpServletRequest request,HttpServletResponse response,Model model){
		
		String tel="";
		String msg="";
		
		String code=(String)request.getSession().getAttribute("code");
		
		//this.setCookie(request, response, userId);//设置cookie
		
		return "";
	}
	
	//设置Cookie
	public void setCookie(HttpServletRequest request,HttpServletResponse response, Integer userId){//设置cookie
		String enstr = Md5.Md5plain(request.getHeader("user-agent"))+Md5.Md5plain(String.valueOf(userId));

		CookieUtil.addCookie(response, "key", enstr, 3600*24*30);
		CookieUtil.addCookie(response, "userId", String.valueOf(userId), 3600*24*30);
		//
		PhoneCheckBean pc=(PhoneCheckBean)this.getPhoneCheckService().selectByUserId(userId);
		if(pc==null) {
			Map cookieMap=CookieUtil.ReadCookieMap(request);
	
			int superId;
			int agentId;

			//封装一下，防止保存的时候异常
			try{
				superId=Integer.parseInt(cookieMap.get("superId").toString());
			}catch(Exception e){
				superId=1;
			}
			
			try{
				agentId=Integer.parseInt(cookieMap.get("agentId").toString());
			}catch(Exception e){
				agentId=1;
			}
			
			pc = new PhoneCheckBean();
			
			
			pc.setSuperId(superId);
			pc.setAgentId(agentId);
			pc.setEncryptCode(enstr);
			pc.setUserId(userId);
			//

			if(this.getPhoneCheckService().insert(pc)){
				log.info("phonecheck：保存：用户浏览器信息存储、校验、记录表成功！用户ID"+userId);
			}else{
				log.info("phonecheck：保存：用户浏览器信息存储、校验、记录表失败！用户ID"+userId);
			}
			
		} else {
			
			pc.setEncryptCode(enstr);
			//
			if(this.getPhoneCheckService().update(pc)) {
				log.info("phonecheck：修改：用户浏览器信息存储、校验、记录表成功！用户ID"+userId);
			}else{
				log.info("phonecheck：修改：用户浏览器信息存储、校验、记录表失败！用户ID"+userId);
			}
		}
	}

	
	//用户获取短信验证码
	@RequestMapping("/getMsg")
	public String getMsg(HttpServletRequest request,HttpServletResponse response,Model model){

		String tel="18667622364";

		Long timeMillis=System.currentTimeMillis();
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			sb.append(r.nextInt(10));
		}
		String code = sb.toString();
		System.out.println(code);
		try{
			HttpSession session=request.getSession();
			
			if(session.getAttribute("code")!=null){
				Long codetime=(Long)session.getAttribute("codetime");
				if(timeMillis-codetime>60000){
					session.removeAttribute("code");
					session.removeAttribute("codetime");
				}else{				
					request.setAttribute("result", "60秒内只能获取一次短信");
					return "result";
				}
			}

			//SendMessage.sendMessage(tel, "您的本次操作验证码为"+code+"，请勿向他人泄漏，以免造成损失，本条短信10分钟内有效【扫贝科技】","");
			
			session.setAttribute("code", code);
			session.setAttribute("codetime", timeMillis);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("result", "短信已发送");
		return "result";
	}
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PhoneCheckService getPhoneCheckService() {
		return phoneCheckService;
	}

	public void setPhoneCheckService(PhoneCheckService phoneCheckService) {
		this.phoneCheckService = phoneCheckService;
	}
	
}
