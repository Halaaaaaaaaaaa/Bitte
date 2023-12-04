package com.bitte.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.TotalShopVO;
import com.bitte.biz.dto.UserVO;
import com.bitte.biz.dto.WishListVO;
import com.bitte.biz.service.TotalShopService;
import com.bitte.biz.service.WishListService;


@Controller
public class TotalShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(TotalShopController.class);
	
	@Autowired
	private TotalShopService totalShopService;
	@Autowired
	private WishListService wishService;
	
	//���� ����ȭ�� ��ǰ ��ü ����Ʈ
	@GetMapping(value = "/totalShopMain")
	public String shopMain(TotalShopVO vo, Model model) {
		List<TotalShopVO> total_shopAllList = totalShopService.total_shopAllList(vo);
		model.addAttribute("total_shopAllList", total_shopAllList);
		logger.info("TotalShopVO : " + vo.toString());
		logger.info("total_shopAllList : " + vo.toString());
		
		return "total_shop/totalShopMain";
	}
	
	//���� ����ȭ�� ��ǰ ī�װ��� ����Ʈ
	@GetMapping(value = "/totalShopCategory")
	public String shopMain_category(TotalShopVO vo, Model model) {
		List<TotalShopVO> total_shopList = totalShopService.total_shopList(vo.getP_category());
		model.addAttribute("total_shopList", total_shopList);
		logger.info("TotalShopVO : " + vo.toString());
		logger.info("total_shopList : " + vo.toString());
		
		return "total_shop/totalShopCategory";
	}
    
	//���� ������ ȭ��
	@GetMapping("/totalShopDetail")
	public String shopdetail(Model model, ShopVO vo, HttpSession session,
							@RequestParam("p_code") int p_code) {

		UserVO uservo = (UserVO) session.getAttribute("loginUser");

		ShopVO shop_detail = totalShopService.total_shopDetail(vo);
		
		WishListVO wish = new WishListVO();
		
		wish.setId(uservo.getId());
		wish.setP_code(shop_detail.getP_code());
		
		model.addAttribute("uservo", uservo);
		model.addAttribute("shop_detail", shop_detail);
		
		logger.info("ShopVO : " + vo.toString());
		logger.info("shop_detail : " + vo.toString());
		
		return "total_shop/totalShopDetail";
	}
	
	//���� ������ ȭ�� �� ���ø���Ʈ
	



}
