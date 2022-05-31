package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UserInfoDao.java
 * @�๦��˵��: 
 * @����: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @����: 2022��5��25������3:28:41
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: ZhouXinXin</li> 
 * 	 <li>����: 2022��5��25������3:28:41</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoDao {

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
}
