$(function() {
//点击logo回到首页
	$(document).on("click", ".logo img", function() {
		window.location.href = "index.html";
	});
	$(document).on("click", ".logoimg", function() {
		window.location.href = "index.html";
	});
});	
	
//��¼�ӿ�
var loginfunc = function(){
	var paras = {}
	paras.username = $("#username").val();//用户名
	paras.pwd = $("#pwd").val();//密码
	console.log(paras)
	$.ajax({
		type:"post",
		datatype:"json",
		url:loginfunc_url,
		data:paras,
		success:function(data){
			console.log(data);
			var code = data.code;
			var message = data.message;
			if(code == 200){
				if(data.result.flag == 1){
					sessionStorage.setItem("userId",data.result.id); //����ֵ
					sessionStorage.setItem("username",data.result.username);
				    window.location.href = "index.html";	
				}else{
					sweetAlert("Sorry..",data.result.message,"error!");
				}
			}else{
				sweetAlert("Oops..", message, "error");
			}
		}
	})
	
}


$(function(){
	
	$("#login_btn").click(function(){
		if($("#username").val()==""){
			sweetAlert("Oops..", "请输入用户名", "error");
		}else if($("#pwd").val()==""){
			sweetAlert("Oops..", "请输入密码", "error");
		}else{
			loginfunc();
		}
		
	})
	
})