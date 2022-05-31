package com.imti.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;

/**@文件名: UserInfoController.java
 * @类功能说明: 
 * @作者: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @日期: 2022年5月25日下午3:38:14
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: ZhouXinXin</li> 
 * 	 <li>日期: 2022年5月25日下午3:38:14</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	//登录
	@RequestMapping("/login")
	public String login(UserInfo userInfo,HttpServletRequest request) throws UnsupportedEncodingException {
		HttpSession session=request.getSession();
		UserInfo userInfoSession=(UserInfo) session.getAttribute("currentUserInfo");
		UserInfo resultUserInfo=userInfoService.login(userInfo);
		if(userInfoSession!=null) {
			return "mian";
		}else {
			if(resultUserInfo!=null) {
				session.setAttribute("currentUserInfo", resultUserInfo);
				return "redirect:../common/main.html";
			}else {
				return "redirect:../login.html?error=1&user_name="+URLEncoder.encode(userInfo.getUser_name(),"UTF-8")+"&user_pwd="+userInfo.getUser_pwd();
			}
		}
	}
	
	//查询
	@RequestMapping("findUserInfo")
	@ResponseBody
	public Map<String,Object> findUserInfo(String searchName,int page,int rows){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("searchName", searchName);
		map.put("start", (page-1)*rows);
		map.put("rows", rows);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("userList", userInfoService.finduserList(map));
		resultMap.put("total",userInfoService.findTotalUserInfo(map));
		return resultMap;
	}
	
	//新增和修改
	@RequestMapping("saveUserInfo")
	@ResponseBody
	public boolean saveUserInfo(UserInfo userInfo,HttpServletRequest request) {
		boolean flag=false;
		HttpSession session=request.getSession();
		UserInfo resultSession=(UserInfo) session.getAttribute("currentUserInfo");
		if(userInfo.getUser_id()==null) {
			userInfoService.insertUserInfo(userInfo);
			userInfo.setOpt_id(resultSession.getUser_id());
			flag=true;
		}else {
			userInfoService.updateUserInfo(userInfo);
			flag=true;
		}
		return flag;
	}

	//删除
	@RequestMapping("deleteUserInfo")
	@ResponseBody
	public boolean deleteUserInfo(UserInfo userInfo) {
		int result=userInfoService.deleteUserInfo(userInfo.getUser_id());
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//查询重名方法
	@RequestMapping("select")
	@ResponseBody
	public boolean select(String user_name) {
		//return userInfoService.findOneUserInfo(user_name);
		if(userInfoService.findOneUserInfo(user_name)!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	//退出
	@RequestMapping("logout")
	@ResponseBody
	public boolean logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return true;
	}
	
	//导出
	@RequestMapping("exportExcel")
	@ResponseBody
	public void exportExcel(String searchName,int page,int rows,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("searchName", searchName);
		int start =(page-1)*rows;
		map.put("start", start);
		map.put("rows", rows);
		
		List<UserInfo> userList=userInfoService.finduserList(map);
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+new String("用户信息.xls".getBytes(),"ISO-8859-1"));
			response.setContentType("application/x-excel;charset=UTF-8");
			OutputStream outputStream;
			outputStream=response.getOutputStream();
			
			userInfoService.exportExcel(userList, outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
