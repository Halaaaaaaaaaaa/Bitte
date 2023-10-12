$(document).ready(function() {
	// 상품상세정보 로딩 시에 상품평 목록을 조회하여 출력
	reviewList();
});

var p_code = document.getElementById("p_code").value;

// 상품평 목록 불러오기
function reviewList() {
	$.ajax({
		type : 'GET',
		url : 'reviews/list',
		dataType : 'json',
		data : {
			p_code : p_code
		},
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		success : function(data) {
			console.log(data);
			$("#review-container").empty();
			var reviewList = data.commentList;
				if (reviewList.length > 0) {
					var html = "";
						reviewList.forEach(function(review) {
						html += "<div class='review-item'>";
						if (review.r_point === 5) {
							html += "<strong>💗💗💗💗💗</strong>";
						} else if (review.r_point === 4) {
							html += "<strong>💗💗💗💗🖤</strong>";
						} else if (review.r_point === 3) {
							html += "<strong>💗💗💗🖤🖤</strong>";
						} else if (review.r_point === 2) {
							html += "<strong>💗💗🖤🖤🖤</strong>";
						} else if (review.r_point === 1) {
							html += "<strong>💗🖤🖤🖤🖤</strong>";
						}
						html += "&emsp;<strong>작성자 : " + review.id + "</strong>";
						html += "&emsp;&emsp;<span>작성일 : " + formatDate(review.regdate) + "</span>";
						html += "<br><br>";
						html += "<span style='font-size: 16px;'>" + review.r_content + "</span>";
						html += "</div>";
					});
					$("#review-container").html(html);
				} else {
				$("#review-container").html(
						"<p>&emsp;아직 리뷰가 없어요.</p>");
			}
		},
			error : function() {
			alert("조회하지 못했습니다.")
		}
	});
}

// 작성일
function formatDate(dateString) {
	var date = new Date(dateString);
	var year = date.getFullYear();
	var month = String(date.getMonth() + 1).padStart(2, '0');
	var day = String(date.getDate()).padStart(2, '0');

	return year + "-" + month + "-" + day;
}

// 상품 댓글 등록
function save_review() {
	var selectedRating = $('input[name="r_point"]:checked').val();
	if (selectedRating === undefined) {
		alert("별점을 선택해주세요.");
		return;
	}

	var r_content = $("#r_content").val();
	if (r_content.length > 51) {
		$("#errorMessage").text("50글자 이내로 작성 및 등록 가능합니다.");
		alert("50글자 이내로 작성 및 등록 가능합니다.");
		return;
	}

	$.ajax({
		type : 'POST',
		url : 'reviews/insert',
		data : {
			p_code : p_code,
			r_content : r_content,
			r_point : selectedRating
		},
		success : function(data) {
			var uservo = document.getElementById("id").value;
			if (data == 'success') {
				reviewList(); // 상품평 목록 요청함수 호출
				$("#r_content").val("");
				$('input[name="r_point"]').prop('checked', false);
				alert("리뷰가 작성되었습니다.");
			} else {
				alert("로그인 후에 이용해주시기 바랍니다.");
				location.href = "login_page";
			}
		},
		error : function(request, status, error) {
			$("#errorMessage").text("50글자 이내로 작성 및 등록 가능합니다.");
		}
	});
}