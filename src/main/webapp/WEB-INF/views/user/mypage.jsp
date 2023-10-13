<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BITTE SCHÖN</title>
	<link rel="shortcut icon" href="img/favicon.png">
	<link rel="stylesheet" type="text/css" href="css/user/mypage.css" />
	<script type="text/javascript" src="js/user/mypage.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<div class="mypage">
		<div id="sidebar">
			<div class="user-wrap">${user.id}님</div>
			<div>
				<p>쇼핑 정보</p> 
				<a href="#" class="menu-button" onclick="loadPage('orderPage')">주문 내역</a>
				<a href="#" class="menu-button" onclick="loadPage('cancelPage')">취소/반품/교환 내역</a> 
				<a href="#" class="menu-button" onclick="loadPage('wishlistPage')">위시리스트</a>
			</div>
			<div>
				<p>회원 정보</p> 
				<a href="#" class="menu-button" onclick="loadPage('userInfoPage')">회원 정보</a>
				<a href="#" class="menu-button" onclick="loadPage('deliveryPage')">배송지 관리</a> 
				<a href="#" class="menu-button" onclick="loadPage('personalInqPage')">1:1 문의내역</a> 
				<a href="#" class="menu-button" onclick="loadPage('productInqPage')">상품 문의내역</a>
			</div>
		</div>

		<div id="content">
			<%@ include file="../user/mypage/orderPage.jsp"%>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>