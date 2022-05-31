function logout(){
	var flag=confirm("您确定要退出吗？");
	if(flag){
		$.get("../userInfo/logout.do",function(result){
			if(result==true){
				window.top.location.href="../login.html";
			}
		},"json");
	}
}