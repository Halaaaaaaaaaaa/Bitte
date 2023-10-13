//로그아웃 처리
function logoutClicked() {
    var confirmed = confirm("로그아웃 하시겠습니까?");
    if (confirmed) {
    	alert("로그아웃 되었습니다.");
        window.location.href = "/logout";
    }
}


//문의하기 모달창
$(document).ready(function() {
	// Open Modal
	$(".open").on("click", function() {
		$(".container").fadeIn();
	});

	// Close Modal
	$(".close").on("click", function() {
		$(".container").fadeOut();
	});
});