var searchName="";
function init(){
	var searchName=$("#searchName").val();
	var page=$("#page").val();
	var rows=$("#rows").val();
	$.ajax({
		url:"../userInfo/findUserInfo.do",
		data:{searchName:searchName,
			page:page,
			rows:rows
		},
		type:"post",
		dataType:"json",
		success:function(result){
			var header="<table border='1px' cellspcaing='0' width='900px' align='center'>"+
			"<tr><th colspan='7'>用户列表</th></tr>"+
			"<tr>"+
			"<th colspan='7'>"+
			"<input type='text' name='searchName' id='searchName'/>"+
			"<a href='javascript:searchByName()'>查询</a>"+
			"&nbsp;&nbsp;&nbsp;"+
			"<a href='editUserInfo.html'>新增</a>"+
			"&nbsp;&nbsp;&nbsp;"+
			"<a href='../userInfo/exportExcel.do?page="+page+"&rows="+$("#rows").val()+"'>导出</a>"+
			"</th>"+
			"</tr>"+
			"<tr>"+
			"<th>编号</th>"+
			"<th>姓名</th>"+
			"<th>密码</th>"+
			"<th>年龄</th>"+
			"<th>创建时间</th>"+
			"<th>备注</th>"+
			"<th>操作</th>"+
			"</tr>";
			var content="";
			$.each(result.userList,function(index,userInfo){
				content+="<tr align='center'>"+
							"<td>"+userInfo.user_id+"</td>"+
							"<td>"+userInfo.user_name+"</td>"+
							"<td>"+userInfo.user_pwd+"</td>"+
							"<td>"+userInfo.user_age+"</td>"+
							"<td>"+userInfo.user_createtime+"</td>"+
							"<td>"+userInfo.user_remark+"</td>"+
							"<td>"+
								"<a href='editUserInfo.html?type=1&user_id="+userInfo.user_id+"&user_name="+userInfo.user_name+"&user_pwd="+userInfo.user_pwd+"&user_age="+userInfo.user_age+"&user_remark="+userInfo.user_remark+"'>修改</a>"+
								"&nbsp;&nbsp;&nbsp;"+
								"<a href='javascript:deleteUserInfo("+userInfo.user_id+")'>删除</a>"+
							"</td>"+
						 "</tr>";
			});
			$("#userList").html(header+content+"</table>");
			$("#total").html(result.total);
			var rows=$("#rows").val();
			$("#totalPage").html(Math.ceil(result.total/rows));
			$("#searchName").val(searchName);
		}
	});
}

$(function(){
	init();
});

function searchByName(){
	$("#page").val(1);
	init();
}

//上一页
function upPage(){
	var page=$("#page").val();
	if(page==1){
		$("#page").val(1);
	}else{
		$("#page").val(--page);
		init();
	}
}

//下一页
function downPage(){
	var page=$("#page").val();
	var totalPage=$("#totalPage").html();
	
	if(page==totalPage){
		$("#page").val(totalPage);
	}else{
		$("#page").val(++page);
		init();
	}
}

//跳转
function changevalue(){
	var page=$("#page").val();
	var totalPage=$("#totalPage").html();
	page=parseInt(page);
	totalPage=parseInt(totalPage);
	
	if(page>totalPage){
		$("#page").val(totalPage);
	}else if(page<0){
		$("#page").val(1);
	}
	init();
}

//显示条数
function changeRows(){
	$("#page").val(1);
	init();
}

function deleteUserInfo(user_id){
	var flag=confirm("您确认要删除吗？");
	if(flag){
		$.post("../userInfo/deleteUserInfo.do",{user_id:user_id},function(result){
			if(result){
				alert("删除成功！");
				window.location.href="userList.html";
			}else{
				alert("系统繁忙，请稍后再试！");
			}
		},"json");
	}
}