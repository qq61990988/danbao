package com.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.sword.wechat4j.common.Config;
import org.sword.wechat4j.token.TokenProxy;

import com.danbao.service.UserService;

public class WechatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WechatServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("请求POS:");
		
		//response.setCharacterEncoding("UTF-8");

		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		UserService userService = (UserService)ctx.getBean("userService");		
		MyWechat myWechat = new MyWechat(request);
		myWechat.setUserService(userService);		
		
		String result = myWechat.execute();
		System.out.println(Config.instance().getAppid());
		System.out.println(Config.instance().getAppSecret());
		System.out.println(Config.instance().getToken());
		System.out.println(Config.instance().getJsApiTicketServer());
		System.out.println(Config.instance().getUrl());
		System.out.println(TokenProxy.accessToken());
		System.out.println("返回的数据："+result);


		
		//response.getOutputStream().write(result.getBytes());
		
		
		try {  
            request.setCharacterEncoding("UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        response.setCharacterEncoding("UTF-8");  
        /*
        CoreServiceImpl coreService=new CoreServiceImpl();
        // 调用核心业务类接收消息、处理消息  
        String respMessage = coreService.processRequest(request);  
  		*/
        // 响应消息  
        PrintWriter out = null;  
        try {  
            out = response.getWriter();  
            out.print(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            out.close();  
            out = null;  
        }  
        
    }  
}
