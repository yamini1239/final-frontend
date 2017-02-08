package com.niit.bc.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String welcome(){
		return "/v_home/index";
	}
}
