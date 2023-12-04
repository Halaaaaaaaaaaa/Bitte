<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link rel="shortcut icon" href="img/favicon.png">
	<link rel="stylesheet" type="text/css" href="css/user/wishListPage.css" />
	<script type="text/javascript" src="js/user/mypage.js"></script>
</head>
<body>
	<div>
		안녕, 나는 위시리스트 페이지.<br>
		<c:if test="${empty wishList}">
		    <p>찜한 상품이 없습니다.</p>
		</c:if>
		
		<c:if test="${not empty wishList}">
		    <c:forEach var="wish" items="${wishList}">
		        <p>회원ID: ${wish.id}<br>
		        	상품코드: ${wish.p_code}</p>
		    </c:forEach>
		</c:if>
	</div>

</body>
</html>
