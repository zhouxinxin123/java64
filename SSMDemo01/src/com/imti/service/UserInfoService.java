package com.imti.service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UsreInfoService.java
 * @�๦��˵��: 
 * @����: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @����: 2022��5��25������3:38:53
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: ZhouXinXin</li> 
 * 	 <li>����: 2022��5��25������3:38:53</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoService {

	//��¼
	public UserInfo login(UserInfo userInfo);
	
	//����
	public int insertUserInfo(UserInfo userInfo);
	
	//�޸�
	public int updateUserInfo(UserInfo userInfo);
	
	//ɾ��
	public int deleteUserInfo(int user_id);
	
	//��ѯ
	public List<UserInfo> finduserList(Map<String,Object> map);
	
	//��ѯ�Ƿ�����
	public UserInfo findOneUserInfo(String user_name);
	
	//��ѯ������
	public int findTotalUserInfo(Map<String,Object> map);
	
	//����
	public void exportExcel(List<UserInfo> userList,OutputStream outPutStream);
}
