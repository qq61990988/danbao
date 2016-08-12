package com.longge.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener,ServletRequestListener {

	private HttpServletRequest request=null;
	
	public void sessionCreated(HttpSessionEvent event) {
		
		// TODO Auto-generated method stub
		
			HttpSession session=event.getSession();

	        System.out.println("创建会话");
	        
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		
		HttpSession session=event.getSession();
        
       
    }
	
	public void requestInitialized(ServletRequestEvent event) {
		
     
        request = (HttpServletRequest)event.getServletRequest();
		  
	}
	
	public void requestDestroyed(ServletRequestEvent event){
		
	}
}
