package com.bitte.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(TotalShopController.class);
	
	//@Autowired
	//private TotalShopService totalShopService;
	
	//상품 주문 화면
	@GetMapping(value = "/cartPage")
	public String orderForm(Model model) {
		
		return "cart/cartPage";
	}
	
	

}
