package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@文件名: UserInfoDao.java
 * @类功能说明: 
 * @作者: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @日期: 2022年5月25日下午3:28:41
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: ZhouXinXin</li> 
 * 	 <li>日期: 2022年5月25日下午3:28:41</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoDao {

	//登录
	public UserInfo login(UserInfo userInfo);
	
	//新增
	public int insertUserInfo(UserInfo userInfo);
	
	//修改
	public int updateUserInfo(UserInfo userInfo);
	
	//删除
	public int deleteUserInfo(int user_id);
	
	//查询
	public List<UserInfo> finduserList(Map<String,Object> map);
	
	//查询是否重名
	public UserInfo findOneUserInfo(String user_name);
	
	//查询总条数
	public int findTotalUserInfo(Map<String,Object> map);
}
