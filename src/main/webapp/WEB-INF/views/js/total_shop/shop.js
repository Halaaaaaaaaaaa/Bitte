//상단 카테고리별 화면 표출 기능
$(document).ready(function() {
	$(".category-link").click(function(e) {
		e.preventDefault(); // 기본 동작 막기
		var category = $(this).data("category");

		$.ajax({
			type: "GET",
			url: "totalShopCategory?p_category=" + category,
			success: function(response) {
				$(".shopProduct").html(response);
			},
			error: function(xhr, status, error) {
				console.error("AJAX 요청 실패: " + error);
			}
		});
	});
});


//아코디언    
$(document).ready(function(){ 
	$('.accodion-header').toggleClass('inactive-header');

    $('.accodion-header').click(function () {
        if($(this).is('.inactive-header')) {
            $('.active-header').toggleClass('active-header').toggleClass('inactive-header').next().slideToggle().toggleClass('open-content');
            $(this).toggleClass('active-header').toggleClass('inactive-header');
            $(this).next().slideToggle().toggleClass('open-content');
        }		
        else {
            $(this).toggleClass('active-header').toggleClass('inactive-header');
            $(this).next().slideToggle().toggleClass('open-content');
        }
    });
    return false;
});

class Accordion {
   constructor(heading) {
      this.heading = heading;
   }
   showOne() {
      const accordionHeading = document.querySelectorAll(this.heading);
      
      accordionHeading.forEach((item, key) => {
         item.addEventListener('click', () => { 
            accordionHeading.forEach(element => {
               element.classList.contains('active') ? 
                  element.classList.remove('active') : null;
            });
            item.classList.add('active');
         });
      });
   }
   showAll() {
      const accordionHeading = document.querySelectorAll(this.heading);
      accordionHeading.forEach((item, key) => {
         item.addEventListener('click', () => { 
            item.classList.contains('active') ? 
               item.classList.remove('active') :            
               item.classList.add('active');
         });
      });
   }
}
const accordion = new Accordion('.title');
accordion.showAll();
	

//scroll to top
var Btn = document.getElementById("scrollToTopBtn");
var rootElement = document.documentElement;

function scrollToTop() {
  rootElement.scrollTo({
    top: 0,
    behavior: "smooth"
  })
}
Btn.addEventListener("click", scrollToTop);


//wish list(찜하기) 이벤트
//추후 작성


//주문하기 버튼 이벤트
function goBuy() {
	var uservo = $("#id").val();
	var size = $("#size").val();
	
	if(uservo==null || uservo=="") {
		alert("로그인 후 이용해주시기 바랍니다.");
		location.href="login_page";
	} else {
		if(size==null || size=="") {
			alert("옵션을 선택해주세요.");
		} else {
			location.href="orderForm";
		}
	}
}

//장바구니 버튼 이벤트
function goCart() {
	var uservo = $("#id").val();
	var size = $("#size").val();
	
	if(uservo==null || uservo=="") {
		alert("로그인 후 이용해주시기 바랍니다.");
		location.href="login_page";
	} else {
		if(size==null || size=="") {
			alert("옵션을 선택해주세요.");
		} else {
			location.href="cartPage";
		}
	}
}
