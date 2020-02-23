function getTopHtml(index) {
    console.log(index)
    $(".nav_box .b" + index).addClass("on");
    getplaceholder("txtNavSearch", "请输入关键词");
    $("#txtNavSearch").keydown(function (e) {
        if (e.keyCode == 13) {
            searchData();
        }
    });

    //顶部菜单选择
    var nownav = "";
    $(".top_div .nav_box_all .nav_box .box").mouseenter(function () {
        $(".nav_two_all").stop(true, false).slideUp(300);
        nownav = $(this).attr("navid");
        if (nownav == 2) {
            $("#nav_two" + nownav).slideDown(300);
        } else {
            $(".nav_two_all").stop(true, false).slideUp(300);
        }
    });
    $(".top_div .nav_box_all").mouseleave(function () {
        $(".nav_two_all").stop(true, false).slideUp(300);
    });
}


function searchData() {
    var str = $("#txtNavSearch").val();
    setCookie("SearchTxt", str);
    location.href = "/searchList.html?keywords="+str;
}


$(function() {

//	getTopHtml(1);

	//轮播图
	var mySwiper = new Swiper('#swiper-container-id1', {
		autoplay: true,
		autoplay: 5000,
		// 如果需要前进后退按钮
		nextButton: '.swiper-button-next',
		prevButton: '.swiper-button-prev'
	});
});
