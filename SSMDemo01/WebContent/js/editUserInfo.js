//提交表单
function saveUserInfo(){
	$.ajax({
		url:"../userInfo/saveUserInfo.do",
		data:$("#saveUserInfo").serialize(),
		type:"post",
		dataType:"json",
		success:function(result){
			if(result){
				alert("保存成功！");
				window.location.href="userList.html";
			}else{
				alert("保存失败！");
			}
		},
		error:function(result){
			alert("系统繁忙，请稍后操作！")
		}
	});
}

//修改取值
function getQueryString(name){
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
				var url=decodeURI(decodeURI(window.location.search));	//获取返回路径
				var r=url.substr(1).match(reg);
				if(r!=null){
					return unescape(r[2]);
				}
				return null;
			}
			
$(function(){
	var type=getQueryString("type");
	var user_id=getQueryString("user_id");
	var user_name=getQueryString("user_name");
	var user_pwd=getQueryString("user_pwd");
	var user_age=getQueryString("user_age");
	var user_remark=getQueryString("user_remark");
	
	$("#user_id").val(user_id);
	$("#user_name").val(user_name);
	$("#user_pwd").val(user_pwd);
	$("#user_age").val(user_age);
	$("#user_remark").val(user_remark);
	
	if(type==1){
		$("#user_name").attr("disabled","disabled")
	}
});

//失焦事件
$("#user_name").blur(function(){
	$.ajax({
		url:"../userInfo/select.do",
		data:{user_name:$("#user_name").val()},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result==true){
				$("#space").html("用户名不可重复！");
				$("#space").css("color", "red");
				$("#user_name").val("");
			}else{
				$("#space").html("");
			}
		}
	});
});

//聚焦事件
$("#user_name").focus(function(){
	$("#space").html("");
});
