package com.longge.util;


public class QuartzJob {
		
	public void run()  
	  {  
		/*List list=this.getUserService().getUserInfoByTel("18968586648");
	    System.out.println("Quartz 的任务调度！！！ ");  
	    if(list.size()>0){
	    	UserInfo userInfo=(UserInfo)list.get(0);
	    	System.out.println(userInfo.getName());

			Calendar date = new GregorianCalendar();
		    SendMailThread smThread = new SendMailThread("61990988@qq.com", "任务调度", userInfo.getTel(), "测试一下：现在时间是："+date.getTime());
	        smThread.start();
	    }*/
		
		try{

			String access_token=HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxba66fa4a988210dd&secret=7f135ee05bb12055f9e69847df5cef87");
			
			System.out.println("access_token:"+access_token);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Quartz 的任务调度！！！ ");  
	  }
}
