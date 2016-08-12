package com.longge.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	 /**
     * 
     * @param response
     * @param name cookie名称
     * @param path cookie存放路径
     * @param value cookie值
     * @param maxAge cookie最长时间
     */
   public static void addCookie(HttpServletResponse response, String name,String path, String value, int maxAge) {        
       Cookie cookie = new Cookie(name, value);
       cookie.setPath(path);
       if (maxAge>0) cookie.setMaxAge(maxAge);
       response.addCookie(cookie);
   }
   /**
    * 
    * @param response
    * @param name cookie名称
    * @param value cookie值
    * @param maxAge cookie最长时间
    */
  public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {        
      Cookie cookie = new Cookie(name, value);
      //if (maxAge>0) 
      cookie.setPath("/");
      cookie.setMaxAge(maxAge);
      response.addCookie(cookie);
  }
  public static void addCookie(HttpServletResponse response, String name, String value, int maxAge,String domain) {        
      Cookie cookie = new Cookie(name, value);
      cookie.setDomain(domain);
      cookie.setPath("/");
      //if (maxAge>0) 
      cookie.setMaxAge(maxAge);
      response.addCookie(cookie);
  }
  public static void addCookie(HttpServletResponse response, String name, String value, int maxAge,String domain,boolean secure) {        
      Cookie cookie = new Cookie(name, value);
      cookie.setDomain(domain);
      cookie.setPath("/");
      //if (maxAge>0) 
      cookie.setSecure(secure);
      cookie.setMaxAge(maxAge);
      response.addCookie(cookie);
  }
  /**
   * 
   * @param response
   * @param name cookie名称
   * @param value cookie值
   * @param maxAge cookie最长时间
   */
 public static void addCookie(HttpServletResponse response, String name, String value) {        
     Cookie cookie = new Cookie(name, value);

     response.addCookie(cookie);
 }
   
 /**
  * 
  * @param response
  * @param name cookie名称
  * @param value cookie值
  * @param maxAge cookie最长时间
  */
public static void addCookie(HttpServletResponse response, String name, String value,String domain,boolean secure) {        
    Cookie cookie = new Cookie(name, value);
    cookie.setDomain(domain);
    cookie.setPath("/");
    //if (maxAge>0) 
    cookie.setSecure(secure);
    response.addCookie(cookie);
}
   /**
    * 
    * 获取cookie的值
    * @param request
    * @param name cookie的名称
    * @return
    */
   public static String getCookieByName(HttpServletRequest request, String name) {
    Map<String, Cookie> cookieMap = CookieUtil.readCookieMap(request);
       if(cookieMap.containsKey(name)){
           Cookie cookie = (Cookie)cookieMap.get(name);
           return cookie.getValue();
       }else{
           return null;
       }
   }
   public static Cookie getCookieObjectByName(HttpServletRequest request, String name) {
       Map<String, Cookie> cookieMap = CookieUtil.readCookieMap(request);
          if(cookieMap.containsKey(name)){
              Cookie cookie = (Cookie)cookieMap.get(name);
              return cookie;
          }else{
              return null;
          }
      }
   protected static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
       Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
       Cookie[] cookies = request.getCookies();
       if (null != cookies) {
           for (int i = 0; i < cookies.length; i++) {
               cookieMap.put(cookies[i].getName(), cookies[i]);
           }
       }
       return cookieMap;
   }
   
   /*public static void deleteCookieByName(HttpServletRequest request,HttpServletResponse response, String name) {
       Map<String, Cookie> cookieMap = CookieUtil.readCookieMap(request);
          if(cookieMap.containsKey(name)){
              Cookie cookie = (Cookie)cookieMap.get(name);
              cookie.setDomain(Constants.COOKIE_DOMAIN);
              cookie.setPath("/");
              cookie.setMaxAge(0);
              response.addCookie(cookie);
		}
	}*/
   
	

   public static Map ReadCookieMap(HttpServletRequest request){  //把cookie放到Map
	    Map cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie.getValue());
	        }
	    }
	    return cookieMap;
	}
	
	
}
