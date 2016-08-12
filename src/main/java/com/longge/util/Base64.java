package com.longge.util;


public class Base64 {
	
		 /** 	      
	     * 加密
	     */  
	    public static String decode(String str) {  
	    	
	        return new String(org.apache.commons.codec.binary.Base64.decodeBase64(str.getBytes()));  
	    }  
	  
	    /** 
	     * 解密
	     */  
	    public static String encode(String str) {  
	        return new String(org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes()));  
	    }  
	
	    /** 
	     * 校验
	     */ 
	    public static boolean Validator(String str, String code){
	    	if(Base64.encode(str).equals(code)){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }	 
}
