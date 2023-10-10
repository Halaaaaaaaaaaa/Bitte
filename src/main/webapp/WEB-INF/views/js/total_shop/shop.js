/**
 * 
 */
$(document).ready(function() {
	// 카테고리 버튼 클릭 이벤트 처리
	$(".category-link").click(function(e) {
		e.preventDefault(); // 기본 동작 막기
		var category = $(this).data("category");

		// AJAX 요청 보내기
		$.ajax({
			type: "GET",
			url: "totalShopCategory?p_category=" + category,
			success: function(response) {
				// total_shop_category.jsp의 내용을 로드하여 .shopProduct에 삽입
				$(".shopProduct").html(response);
			},
			error: function(xhr, status, error) {
				console.error("AJAX 요청 실패: " + error);
			}
		});
	});
});