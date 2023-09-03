package com.bitte.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitte.biz.dto.Total_shopVO;
import com.bitte.biz.dto.UserVO;
import com.bitte.biz.service.Total_shopService;


@Controller
public class Total_shopController {
	
	@Autowired
	private Total_shopService total_shopService;
	
	//쇼핑 메인화면 카테고리별 리스트
	@GetMapping(value = "/total_shop_main")
	public String shopMain(Total_shopVO vo, Model model) {
		
		List<Total_shopVO> total_shopAllList = total_shopService.total_shopAllList(vo);
		model.addAttribute("total_shopAllList", total_shopAllList);
		
		System.out.println(total_shopAllList);
		
		return "total_shop/total_shop_main";
	}
	
	// 쇼핑 디테일 화면
	@GetMapping("/total_shop_detail")
	public String shopdetail(Model model, Total_shopVO vo, HttpSession session) {

		UserVO uservo = (UserVO) session.getAttribute("loginUser");

		Total_shopVO total_shopVO = total_shopService.total_shopDetail(vo);
		
		model.addAttribute("uservo", uservo);
		model.addAttribute("total_shop", total_shopVO);

		return "total_shop/total_shop_detail";
	}
	

}
