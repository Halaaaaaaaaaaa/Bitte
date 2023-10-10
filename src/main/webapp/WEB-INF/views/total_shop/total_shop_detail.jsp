<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/total_shop/total_shop_detail.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/total_shop/shop.js"></script>
</head>
<body>
	<div>   
		<div class="detail-product">
			<div class="shopProduct-span">
				<div>${shop_detail.p_name}_${shop_detail.p_color}</div>
				<div>${shop_detail.p_price}</div>
				<div>
					<p>사이즈</p>
					<select name="size">
						<option value='' selected> -- [필수] 옵션을 선택하세요 -- </option>
						<option value='S'>S</option>
						<option value='M'>M</option>
						<option value='L'>L</option>
					</select>
				</div>
				<div>
					<button>구매하기</button>
				</div>
			</div>
			<div class="shopProduct-img">
				<img class="img" src="img/total_shop/${shop_detail.p_img}.jpg"><br>
			</div>
		</div>
	</div>

    <%@ include file="../footer.jsp"%>
</body>
</html>
