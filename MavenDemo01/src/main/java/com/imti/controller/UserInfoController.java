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

/**@�ļ���: UserInfoController.java
 * @�๦��˵��: 
 * @����: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @����: 2022��5��25������3:38:14
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: ZhouXinXin</li> 
 * 	 <li>����: 2022��5��25������3:38:14</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	//��¼
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
	
	//��ѯ
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
	
	//�������޸�
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

	//ɾ��
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
	
	//��ѯ��������
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
	
	//�˳�
	@RequestMapping("logout")
	@ResponseBody
	public boolean logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return true;
	}
	
	//����
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
			response.setHeader("Content-Disposition", "attachment;filename="+new String("�û���Ϣ.xls".getBytes(),"ISO-8859-1"));
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
