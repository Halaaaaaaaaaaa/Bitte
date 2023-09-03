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
</head>
<body>
	<div>
		<!-- shop main menu -->
		<nav class="shopMenu">
			<div class="shopMenu-bar">
				<div>
					<a href="#">All</a>
				</div>
				<div>
					<a href="#">Outer</a>
				</div>
				<div>
					<a href="#">Top</a>
				</div>
				<div>
					<a href="#">Bottom</a>
				</div>
				<div>
					<a href="#">Dress</a>
				</div>
				<div>
					<a href="#">Acc</a>
				</div>
			</div>
		</nav>


		<div class="shopProduct">
			<c:forEach items="${total_shopAllList}" var="total_shop" varStatus="loop">
				<div class="shopProduct-list">
					<img class="img" src="img/total_shop/${total_shop.p_img}.jpg"><br>
					<div class="shopProduct-span">
						<div>${total_shop.p_name}</div>
						<div>${total_shop.p_price}</div>
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