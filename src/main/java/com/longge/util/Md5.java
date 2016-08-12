package com.longge.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

	/**
	 * 加密
	 */
	public static String Md5plain(String plainText ) {

    	StringBuffer sb=new StringBuffer(""); 
    	
    	try { 
    		
	    	MessageDigest md=MessageDigest.getInstance("MD5"); 
	    	md.update(plainText.getBytes()); 
	    	
	    	byte[] btResult= md.digest(); 
	    	
	    	
	    	for(byte b : btResult){
	    		int bt = b&0xff;
    		if(bt<16){
    			sb.append(0);
    		}
    			sb.append(Integer.toHexString(bt));
    		}
	    	//System.out.println("result: " + buf.toString());//32λ�ļ��� 
	
	    	//System.out.println("result: " + buf.toString().substring(8,24));//16λ�ļ��� 
	
	    } catch (NoSuchAlgorithmException e) { 
	//    	 TODO Auto-generated catch block 
	    	e.printStackTrace(); 
	    } 
	    	return sb.toString();
	}
	
	 /**
	 * 校验
	 */
	public static boolean Validator(String str, String code){
	    	if(Md5.Md5plain(str).equals(code)){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
}
