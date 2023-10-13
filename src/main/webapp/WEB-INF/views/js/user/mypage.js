
//마이페이지 회원 정보 페이지
function loadPage(userInfoPage) {
    $.ajax({
        url: userInfoPage,
        success: function (data) {
            $('#content').html(data);
        }
    });
}

//마이페이지 주문 내역 페이지
function loadPage(orderPage) {
    $.ajax({
        url: orderPage,
        success: function (data) {
            $('#content').html(data);
        }
    });
}
