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
    <script type="text/javascript">
	    document.addEventListener('contextmenu', function (e) {
	        e.preventDefault();
	    });
	</script>
</head>
<body>
	<div>   
		<div class="detail-product">
			<!-- 상품 info -->
			<div class="shopProduct-span">
				<div>${shop_detail.p_name.toUpperCase()}_${shop_detail.p_color.toUpperCase()}</div>
				<div>${shop_detail.p_price}원</div><br>
				<div>
					<c:choose>
						<c:when test="${shop_detail.p_category ==5}">
							<div>
								<br>
							</div>
						</c:when>
						<c:otherwise>
							<div>
								<p>사이즈</p>
								<select name="size">
									<option value='' selected> -- [필수] 옵션을 선택하세요 -- </option>
									 <option class="centered" value='dash' disabled>----------------------------------------</option>
									<option value='S'>S</option>
									<option value='M'>M</option>
									<option value='L'>L</option>
								</select>
							</div><br>
						</c:otherwise>
					</c:choose>
				</div>
				<div>
					<button class="buy">BUY NOW</button>
					<button class="cart">ADD TO CART</button>
				</div>
				<!-- info accodion -->
				<div class="accodion-container">
				    <div>
				        <p class="accodion-header"><b>Product Info</b></p> 
				        <div class="accodion-content">
				            <p>컨텐츠 내용</p> 
				        </div>
				    </div>
				    <div>
				        <p class="accodion-header"><b>Exchange & Refund</b></p> 
				        <div class="accodion-content">
				            <p>컨텐츠 내용</p> 
				        </div>
				    </div>
				</div>
				<!-- wish list -->
				<div id="wishList-wrapper">
					<input type="radio" name="" value="1" id="wish_point"><label for="wish_point">💗</label>
				</div>
			</div>
			<!-- 상품 이미지 -->
			<div class="shopProduct-img">
				<div>
					<div class="imgPoster">
						<img src="img/total_shop/${shop_detail.p_img}.jpg" id="imgPoster_d">
					</div>
				    <div class="imgDetail">
				    	<img src="img/total_shop/${shop_detail.p_img_detail}.jpg" id="imgDetail_d"><br>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- info review -->
	<div id="review-container">
	</div>
	<div class="rcontainer">
		<p>리뷰</p>
		<hr>
		<form id="reviewForm" name="reviewForm" method="post">
			<div id="reviewinsert">
				<div id="reviewpoint">
					<fieldset>
						<span class="text-bold">평점을 선택해주세요</span>
						<input type="radio" name="rpoint" value="5" id="rpoint5"><label for="rpoint5">💗</label>
						<input type="radio" name="rpoint" value="4" id="rpoint4"><label for="rpoint4">💗</label>
						<input type="radio" name="rpoint" value="3" id="rpoint3"><label for="rpoint3">💗</label>
						<input type="radio" name="rpoint" value="2" id="rpoint2"><label for="rpoint2">💗</label>
						<input type="radio" name="rpoint" value="1" id="rpoint1"><label for="rpoint1">💗</label>
					</fieldset>
				</div>
				<span>
                	<input type="text" maxlength="50" id="rcontent" name="rcontent" placeholder="50자 이내로 후기를 입력해주세요" />
                </span>&emsp;&emsp;
				<span id="button">
					<a href='#' onClick="save_review()" class="btn">등록</a>
				</span>
			</div>
			<input type="hidden" value="${total_ent.tseq}" id="tseq" name="tseq" />
        	 
		</form>
	</div>
	
	<div class="container">
    <form id="reviewListForm" name="reviewListForm" method="post">
        <div id="reviewList"></div>
    </form>
    </div>
	<script type="text/javascript" src="js/total_shop/shop.js"></script>
	

    <%@ include file="../footer.jsp"%>
</body>
</html>
