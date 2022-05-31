package com.imti.model;
/**@�ļ���: UserInfo.java
 * @�๦��˵��: 
 * @����: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @����: 2022��5��25������3:24:15
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: ZhouXinXin</li> 
 * 	 <li>����: 2022��5��25������3:24:15</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class UserInfo {

	private Integer user_id;
	private String user_name;
	private String user_pwd;
	private int user_age;
	private String user_remark;
	private String user_createtime;
	private int user_delflag;
	private int user_state;
	private String user_updatetime;
	private int opt_id;
	
	public UserInfo() {}

	//��¼
	public UserInfo(String user_name, String user_pwd) {
		this.user_name = user_name;
		this.user_pwd = user_pwd;
	}

	//����
	public UserInfo(String user_name, String user_pwd, int user_age, String user_remark, int opt_id) {
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_age = user_age;
		this.user_remark = user_remark;
		this.opt_id = opt_id;
	}

	//�޸�
	public UserInfo(Integer user_id, String user_name, String user_pwd, int user_age, String user_remark) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_age = user_age;
		this.user_remark = user_remark;
	}

	//��ѯ
	public UserInfo(Integer user_id, String user_name, String user_pwd, int user_age, String user_remark,
			String user_createtime) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_age = user_age;
		this.user_remark = user_remark;
		this.user_createtime = user_createtime;
	}

	public UserInfo(Integer user_id, String user_name, String user_pwd, int user_age, String user_remark,
			String user_createtime, int user_delflag, int user_state, String user_updatetime, int opt_id) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_age = user_age;
		this.user_remark = user_remark;
		this.user_createtime = user_createtime;
		this.user_delflag = user_delflag;
		this.user_state = user_state;
		this.user_updatetime = user_updatetime;
		this.opt_id = opt_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_remark() {
		return user_remark;
	}

	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}

	public String getUser_createtime() {
		return user_createtime;
	}

	public void setUser_createtime(String user_createtime) {
		this.user_createtime = user_createtime;
	}

	public int getUser_delflag() {
		return user_delflag;
	}

	public void setUser_delflag(int user_delflag) {
		this.user_delflag = user_delflag;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}

	public String getUser_updatetime() {
		return user_updatetime;
	}

	public void setUser_updatetime(String user_updatetime) {
		this.user_updatetime = user_updatetime;
	}

	public int getOpt_id() {
		return opt_id;
	}

	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
	}
}
