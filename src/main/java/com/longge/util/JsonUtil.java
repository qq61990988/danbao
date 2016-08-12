package com.longge.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;



public class JsonUtil {
	 /**
     * 将Json对象转换成Map
     * 
     * @param jsonObject
     *            json对象
     * @return Map对象
     * @throws JSONException
     */
    public static Map toMap(String jsonString){

    	try{
    		  JSONObject jsonObject = new JSONObject(jsonString);
    	        
    	        Map result = new HashMap();
    	        Iterator iterator = jsonObject.keys();
    	        String key = null;
    	        String value = null;
    	        
    	        while (iterator.hasNext()) {

    	            key = (String) iterator.next();
    	            value = jsonObject.getString(key);
    	            result.put(key, value);

    	        }
    	        return result;
    	}catch(Exception e){
    		Map map=new HashMap();
    		map.put("0", "JSON解析出错");
    		System.out.println("JSON解析出错");
    		return map;
    	}
      

    }
}
