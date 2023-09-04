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
    	<div>
	    	<img class="img" src="img/total_shop/${shop_detail.p_img}.jpg"><br>
			<div class="shopProduct-span">
				<div>${shop_detail.p_name}_${shop_detail.p_color}</div>
				<div>${shop_detail.p_price}</div>
			</div>
		</div>
		
	</div>

    <%@ include file="../footer.jsp"%>
</body>
</html>
