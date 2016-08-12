package com.danbao.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danbao.service.UserService;
import com.longge.util.RequestUtil;

@Controller
@RequestMapping("/page")
public class PageMapping {

	@RequestMapping("/login")
	public String user_login(HttpServletRequest request,Model model){

		return "user/login";
	}
	
	@RequestMapping("/index")
	public String user_index(HttpServletRequest request,Model model){

		return "user/index";
	}
	
	@RequestMapping("/uploadImage")
	public String uploadImage(HttpServletRequest request,Model model){

		return "user/uploadImage";
	}

	@RequestMapping("/uploadImageCard")
	public String uploadImageCard(HttpServletRequest request,Model model){

		return "user/uploadImageCard";
	}
}
