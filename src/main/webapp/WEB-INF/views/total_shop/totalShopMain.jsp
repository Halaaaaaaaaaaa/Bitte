<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/total_shop/total_shop_main.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/total_shop/shop.js"></script>
</head>
<body>
	<div>
		<!-- shop main menu -->
		<nav class="shopMenu">
			<div class="shopMenu-bar">
				<div>
					<a href="totalShopMain">All</a>
				</div>
				<div>
					<a href="#" class="category-link" data-category="1">Outer</a>
				</div>
				<div>
					<a href="#" class="category-link" data-category="2">Top</a>
				</div>
				<div>
					<a href="#" class="category-link" data-category="3">Bottom</a>
				</div>
				<div>
					<a href="#" class="category-link" data-category="4">Dress</a>
				</div>
				<div>
					<a href="#" class="category-link" data-category="5">Acc</a>
				</div>
			</div>
		</nav>

		<div class="shopProduct">
			<c:forEach items="${total_shopAllList}" var="total_shop" varStatus="loop">
				<div class="shopProduct-list">
					<a href="totalShopDetail?p_code=${total_shop.p_code}&p_name=${total_shop.p_name}&p_color=${total_shop.p_color}"><img class="img" src="img/total_shop/${total_shop.p_img}.jpg"></a><br>
					<div class="shopProduct-span">
						<div><a href="totalShopDetail?p_code=${total_shop.p_code}&p_name=${total_shop.p_name}&p_color=${total_shop.p_color}&p_price=${total_shop.p_price}">${total_shop.p_name}_${total_shop.p_color}</a></div>
						<div><a href="totalShopDetail?p_code=${total_shop.p_code}&p_name=${total_shop.p_name}&p_color=${total_shop.p_color}&p_price=${total_shop.p_price}">${total_shop.p_price}</a></div>
					</div>
				</div>
				<c:if test="${loop.index % 2 == 1}">
					<div style="clear: both;"></div>
				</c:if>
			</c:forEach>
		</div> 	
	</div>
	
	<%@ include file="../footer.jsp"%>
</body>
</html>