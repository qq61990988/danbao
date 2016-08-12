package com.danbao.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weixin")
public class WeixinController {

	Logger log=Logger.getLogger(this.getClass());
}
