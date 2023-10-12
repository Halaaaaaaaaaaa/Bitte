package com.bitte.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	// HomeController.java
	@RequestMapping(value = "/index")
	public String home() {
		return "index";
	}

}
