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
	

//wish-list

	
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


