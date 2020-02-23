//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}



$(function() {

	if(sessionStorage.getItem("userId") != null) {
		$(".loginregise").empty();
//未完成！！！(点击self.png跳转到个人中心页面）
		var str = "<a id='loginout'><img src="images/exit.png"/></a><a id='meself'><img src="images/self.png"/></a>";
		//		var str = "<a id='loginout'>注销</a><select><option>" + sessionStorage.getItem("username") + "</option><option>修改密码</option><option>修改地址</option></select>";
		$(".loginregise").append(str);
	}
	
	//点击购物车进入购物车页面
	$(document).on("click", ".car", function() {
		if(sessionStorage.getItem("userId") == null) {
			window.location.href = "login.html";
		} else {
			window.location.href = "shoppingCar.html";
		}

	});
	//点击收藏进入收藏页面
	$(document).on("click", ".indexlike", function() {
		if(sessionStorage.getItem("userId") == null) {
			window.location.href = "login.html";
		} else {
			window.location.href = "mylike.html";
		}

	});
	//点击我的订单进入订单页面
	$(document).on("click", ".order", function() {

		if(sessionStorage.getItem("userId") == null) {
			window.location.href = "login.html";
		} else {
			window.location.href = "myOrder.html";
		}

	});

	//点击收藏或购物车
	$(document).on("click", ".addLikeOrCar", function() {

		if(sessionStorage.getItem("userId") == null) {
			window.location.href = "login.html";
		} else {
			var mark = $(this).attr("mark");
			var goodsid = $(this).attr("goodsid");
			addLikeOrCartfunc(mark, goodsid);
		}

	});

	//点击搜索按钮
	$(document).on("click", "#search_btn", function() {
		var search_input = $("#txtNavSearch").val();
		var url_str = window.location.href;
		var _t = encodeURI(encodeURI(search_input));
		window.location.href = "searchResult.html?content=" + _t + "";
	});

	$(document).on("click", "#loginout", function() {

		swal({
			title: "确认退出？",
			text: "此操作将退出当前帐号",
			icon: "warning",
			buttons: ["取消", "确认"],
			dangerMode: true,
		}).then((willDelete) => {

			if(willDelete) {
				sessionStorage.removeItem("userId");
				sessionStorage.removeItem("username");
				$(".loginregise").empty();
//未完成！！！				
				var str = "<a href='register.html'><img src="images/zhuce.png"/></a><a href='login.html'><img src="images/self.png"/></a>";
				$(".loginregise").append(str);
			} else {}

		});

	});
	
})