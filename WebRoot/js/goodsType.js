$(function() {

	//获取产品分类
	goodsTypefunc();
	var element = $("#pageInfo");

	var page = 1;
	var pageSize = 8;
	goodsTypeDetailfunc();

	function goodsTypeDetailfunc() {
		var paras = {};
		paras.page = page;
		paras.pageSize = pageSize;
		paras.id = getUrlParam("typeid"); //产品分类id
		console.log(paras);
		$.ajax({
			type: "post",
			url: goodsTypeDetailfunc_url,
			dataType: "json",
			data: paras,
			success: function(data) {
				//后台返回的需要显示的信息列表
				//根据自己需求再进行前端渲染
				console.log(data);
//				if(getUrlParam("typeid") != 0) {
//					$("#nav li[ref=" + getUrlParam("typeid") + "]").addClass("li-active");
//				}
				$("#goodstypelist").empty();
				if(data.result.goodsList.length > 0) {
					for(var i = 0; i < data.result.goodsList.length; i++) {
						var goodsList = data.result.goodsList[i];
						var id = goodsList.id; //产品id
						var goodsName = goodsList.goodsName; //产品名称
						var picInfo = goodsList.picInfo; //产品url
						var color = goodsList.color; //产品颜色
						var inPrice = goodsList.inPrice; //产品价格
						var categoryID = goodsList.categoryID; //产品类别id
						var goodsstr = "<div class='goods_one' name='entergoodsdetail' goodsid=" + id + ">" +
							"<div class='goodsone_top'>" +
							"<span></span>" +
							"<img goodsid=" + id + " src=" + picInfo + " />" +
							"</div>" +
							"<div class='goodsone_bot'>" +
							"<div class='goodsname' goodsid=" + id + ">" +
							"<span >" + goodsName + "</span>" +
							"</div>" +
							"<div class='goodsinfo'>" +
							"<span class='goodsinfo_color' goodsid=" + id + ">" + color + "</span>" +
							"</div>" +
							"<span class='goodsinfo_price'>" + inPrice + "</span>" +
							"</div>" +
							"</div>" +
							"</div>";
						$("#goodstypelist").append(goodsstr);

					}
				}
				var options = {
					bootstrapMajorVersion: 3, //bootstrap的版本要求
					currentPage: page, //当前页数
					totalPages: Math.ceil(data.result.nCount / pageSize), //总页数
					numberOfPages: pageSize, //每页记录数
					itemTexts: function(type, page, current) { //设置分页按钮显示字体样式
						switch(type) {
							case "first":
								return "首页";
							case "prev":
								return "上一页";
							case "next":
								return "下一页";
							case "last":
								return "末页";
							case "page":
								return page;
						}
					},
					onPageClicked: function(event, originalEvent, type, page) { //分页按钮点击事件
						var paras = {};
						paras.page = page;
						paras.pageSize = pageSize;
						paras.id = getUrlParam("typeid"); //产品分类id
						console.log(paras)
						$.ajax({ //根据page去后台加载数据
							url: goodsTypeDetailfunc_url,
							type: "post",
							dataType: "json",
							data: paras,
							success: function(data) {
								//后台返回的需要显示的信息列表
								//根据自己需求再进行前端渲染
								$("#goodstypelist").empty();
								console.log(data);
								if(data.result.goodsList.length > 0) {
									for(var i = 0; i < data.result.goodsList.length; i++) {
										var goodsList = data.result.goodsList[i];
										var id = goodsList.id; //产品id
										var goodsName = goodsList.goodsName; //产品名称
										var picInfo = goodsList.picInfo; //产品url
										var color = goodsList.color; //产品颜色
										var inPrice = goodsList.inPrice; //产品价格
										var categoryID = goodsList.categoryID; //产品类别id
										var goodsstr = "<div class='goods_one' name='entergoodsdetail' goodsid=" + id + ">" +
											"<div class='goodsone_top'>" +
											"<span></span>" +
											"<img goodsid=" + id + " src=" + picInfo + " />" +
											"</div>" +
											"<div class='goodsone_bot'>" +
											"<div class='goodsname' goodsid=" + id + ">" +
											"<span >" + goodsName + "</span>" +
											"</div>" +
											"<div class='goodsinfo'>" +
											"<span class='goodsinfo_color' goodsid=" + id + ">" + color + "</span>" +
											"</div>" +
											"<span class='goodsinfo_price'>" + inPrice + "</span>" +
											"</div>" +
											"</div>" +
											"</div>";
										$("#goodstypelist").append(goodsstr);
									}
								}
							}
						});
					}
				};
				//初始化分页框
				element.bootstrapPaginator(options);
			}
		})
	}

	$(document).on("click", ".buyright button", function() {
		var buylist = new Array();
		var goodsid = $(this).attr("goodsid");
		var goodsName = $(this).attr("goodsName");
		var num = $(this).attr("num");
		var inPrice = $(this).attr("inPrice");
		var picInfo = $(this).attr("picInfo");
		var buyobj = new Object();
		buyobj.goodsid = goodsid;
		buyobj.goodsName = goodsName;
		buyobj.num = num;
		buyobj.inPrice = inPrice;
		buyobj.picInfo = picInfo;
		buylist.push(buyobj);
		localStorage.setItem("buylist", JSON.stringify(buylist));
		console.log(buylist);
		window.location.href = "okbuy.html";
	});

});