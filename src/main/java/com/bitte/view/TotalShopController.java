package com.bitte.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.TotalShopVO;
import com.bitte.biz.dto.UserVO;
import com.bitte.biz.service.TotalShopService;


@Controller
public class TotalShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(TotalShopController.class);
	
	@Autowired
	private TotalShopService totalShopService;
	
	//쇼핑 메인화면 상품 전체 리스트
	@GetMapping(value = "/total_shop_main")
	public String shopMain(TotalShopVO vo, Model model) {
		List<TotalShopVO> total_shopAllList = totalShopService.total_shopAllList(vo);
		model.addAttribute("total_shopAllList", total_shopAllList);
		logger.info("TotalShopVO : " + vo.toString());
		logger.info("total_shopAllList : " + vo.toString());
		
		return "total_shop/total_shop_main";
	}
	
	//쇼핑 메인화면 상품 카테고리별 리스트
	@GetMapping(value = "/total_shop_category")
	public String shopMain_category(TotalShopVO vo, Model model) {
		List<TotalShopVO> total_shopList = totalShopService.total_shopList(vo.getP_category());
		model.addAttribute("total_shopList", total_shopList);
		logger.info("TotalShopVO : " + vo.toString());
		logger.info("total_shopList : " + vo.toString());
		
		return "total_shop/total_shop_category";
	}
    
	//쇼핑 디테일 화면
	@GetMapping("/total_shop_detail")
	public String shopdetail(Model model, ShopVO vo, HttpSession session) {

		UserVO uservo = (UserVO) session.getAttribute("loginUser");

		ShopVO shop_detail = totalShopService.total_shopDetail(vo);
		
		model.addAttribute("uservo", uservo);
		model.addAttribute("shop_detail", shop_detail);
		
		logger.info("ShopVO : " + vo.toString());
		logger.info("shop_detail : " + vo.toString());
		
		return "total_shop/total_shop_detail";
	}
	

}
