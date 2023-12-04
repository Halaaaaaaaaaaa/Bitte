package com.bitte.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitte.biz.dto.ReviewVO;
import com.bitte.biz.dto.UserVO;
import com.bitte.biz.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	// ���� ���
	@RequestMapping("/insert")
	public String saveComment(ReviewVO vo, HttpSession session) {
		// �α����� �Ǿ� �ִ��� Ȯ��
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		logger.info(vo.toString());
		
		// �α����� �ȵǾ� �ִ� ��� �α��� �������� �̵�
		if (loginUser == null) {
			return "login_page";
		} else {
			vo.setId(loginUser.getId());
			reviewService.insertReview(vo);
			logger.info(vo.toString());
			return "success";
		}
	}
	
	// ���� ����Ʈ
	@GetMapping("/list")
	public Map<String, Object> reciewList(ReviewVO vo) {
		Map<String, Object> reviewInfo = new HashMap<>();
				
		List<ReviewVO> reviewList = reviewService.reviewList(vo.getP_code());
		
		reviewInfo.put("total", reviewList.size());
		reviewInfo.put("commentList", reviewList);
		
		return reviewInfo;
	}
	
}