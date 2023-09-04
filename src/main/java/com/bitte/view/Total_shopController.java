package com.bitte.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.Total_shopVO;
import com.bitte.biz.dto.UserVO;
import com.bitte.biz.service.Total_shopService;


@Controller
public class Total_shopController {
	
	private static final Logger logger = LoggerFactory.getLogger(Total_shopController.class);
	
	@Autowired
	private Total_shopService total_shopService;
	
	//���� ����ȭ�� ��ǰ ��ü ����Ʈ
	@GetMapping(value = "/total_shop_main")
	public String shopMain(Total_shopVO vo, Model model) {
		List<Total_shopVO> total_shopAllList = total_shopService.total_shopAllList(vo);
		model.addAttribute("total_shopAllList", total_shopAllList);
		logger.info("Total_shopVO : " + vo.toString());
		logger.info("total_shopAllList : " + vo.toString());
		
		return "total_shop/total_shop_main";
	}
	
	//���� ����ȭ�� ��ǰ ī�װ��� ����Ʈ
	@GetMapping(value = "/total_shop_category")
	public String shopMain_category(Total_shopVO vo, Model model) {
		List<Total_shopVO> total_shopList = total_shopService.total_shopList(vo.getP_category());
		model.addAttribute("total_shopList", total_shopList);
		logger.info("Total_shopVO : " + vo.toString());
		logger.info("total_shopList : " + vo.toString());
		
		return "total_shop/total_shop_category";
	}
    
	//���� ������ ȭ��
	@GetMapping("/total_shop_detail")
	public String shopdetail(Model model, ShopVO vo, HttpSession session) {

		UserVO uservo = (UserVO) session.getAttribute("loginUser");

		ShopVO shop_detail = total_shopService.total_shopDetail(vo);
		
		model.addAttribute("uservo", uservo);
		model.addAttribute("shop_detail", shop_detail);
		
		logger.info("ShopVO : " + vo.toString());
		logger.info("shop_detail : " + vo.toString());
		
		return "total_shop/total_shop_detail";
	}
	

}
