package com.longge.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class SendMessage {
	
	
	
	public static void sendMessage(String Mobile,String Content,String send_time)throws Exception {

		String JGID="300";
		String YHMC="qq61990988";
		String YHMM="7688550";
		String IpAddr="124.172.234.157:8180";

		String send_content=URLEncoder.encode(Content, "utf-8");
		
		String s=HttpRequest.sendGet("http://"+IpAddr+"/service.asmx/SendMessageStr?Id="+JGID+"&Name="+YHMC+"&Psw="+YHMM+"&Message="+send_content+"&Phone="+Mobile+"&Timestamp=0");
        System.out.println(s);
        
	}
	

	public static int sendSMS(String Mobile,String Content,String send_time) throws MalformedURLException, UnsupportedEncodingException {
		URL url = null;
		
		String JGID="300";
		String YHMC="qq61990988";
		String YHMM="7688550";
		String IpAddr="124.172.234.157:8180";

		String send_content=URLEncoder.encode(Content, "utf-8");
		url = new URL("http://"+IpAddr+"/service.asmx/SendMessageStr?Id="+JGID+"&Name="+YHMC+"&Psw="+YHMM+"&Message="+send_content+"&Phone="+Mobile+"&Timestamp=0");
		BufferedReader in = null;
		int inputLine = 0;
		try {
			
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			inputLine = new Integer(in.readLine()).intValue();
		} catch (Exception e) {
			inputLine=-9;
			e.printStackTrace();
		}
		
		return inputLine;
	}


}
