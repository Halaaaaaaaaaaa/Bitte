<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="shopProduct">
            <c:forEach items="${total_shopList}" var="shop_category" varStatus="loop">
                <div class="shopProduct-list">
                    <a href="total_shop_detail?p_code=${shop_category.p_code}&p_name=${shop_category.p_name}&p_color=${shop_category.p_color}"><img class="img" src="img/total_shop/${shop_category.p_img}.jpg"></a><br>
                    <div class="shopProduct-span">
                        <div><a href="total_shop_detail?p_code=${shop_category.p_code}&p_name=${shop_category.p_name}&p_color=${shop_category.p_color}">${shop_category.p_name}_${shop_category.p_color}</a></div>
                        <div><a href="total_shop_detail?p_code=${shop_category.p_code}&p_name=${shop_category.p_name}&p_color=${shop_category.p_color}">${shop_category.p_price}</a></div>
                    </div>
                </div>
                <c:if test="${loop.index % 2 == 1}">
                    <div style="clear: both;"></div>
                </c:if>
            </c:forEach>
        </div> 
    </div>
</body>
</html>
