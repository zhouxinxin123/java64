package com.imti.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/*import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.UserInfoDao;
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;

/**@�ļ���: UserInfoServiceImpl.java
 * @�๦��˵��: 
 * @����: ZhouXinXin
 * @Email: 1935255066@qq.com
 * @����: 2022��5��25������3:46:01
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: ZhouXinXin</li> 
 * 	 <li>����: 2022��5��25������3:46:01</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfo login(UserInfo userInfo) {
		return userInfoDao.login(userInfo);
	}

	public int insertUserInfo(UserInfo userInfo) {
		return userInfoDao.insertUserInfo(userInfo);
	}

	public int updateUserInfo(UserInfo userInfo) {
		return userInfoDao.updateUserInfo(userInfo);
	}

	public int deleteUserInfo(int user_id) {
		return userInfoDao.deleteUserInfo(user_id);
	}

	public List<UserInfo> finduserList(Map<String, Object> map) {
		return userInfoDao.finduserList(map);
	}

	public UserInfo findOneUserInfo(String user_name) {
		return userInfoDao.findOneUserInfo(user_name);
	}

	public int findTotalUserInfo(Map<String, Object> map) {
		return userInfoDao.findTotalUserInfo(map);
	}

	public void exportExcel(List<UserInfo> userList, OutputStream outPutStream) {
		
	}

	/*@Override
	public void exportExcel(List<UserInfo> userList, OutputStream outputStream) {
		//1.����������
        HSSFWorkbook hwb =new HSSFWorkbook();
        //1.1�����ϲ���Ԫ��
        //CellRangeAddress cellRangeAddress =new CellRangeAddress(0,0,0,4);
        //2.����������
        HSSFSheet sheet = hwb.createSheet("�û���Ϣ��");
        //2.1��Ӻϲ���Ԫ��
        //sheet.addMergedRegion(cellRangeAddress);
        //3.1������һ�м���Ԫ��
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("�û���Ϣ");
        //3.2�����ڶ��м���Ԫ��
        HSSFRow row2 = sheet.createRow(1);
        String[] row2Cell = {"���","����","����","����","����ʱ��","��ע"};
        for (int i =0 ; i < row2Cell.length ; i++ ){
            row2.createCell(i).setCellValue(row2Cell[i]);
        }
        //3.3���������м���Ԫ��
        if(userList!= null && userList.size()>0){
            for(int j=0 ; j<userList.size() ;j++){
                HSSFRow rowUser = sheet.createRow(j+2);
                rowUser.createCell(0).setCellValue(userList.get(j).getUser_id());
                rowUser.createCell(1).setCellValue(userList.get(j).getUser_name());
                rowUser.createCell(2).setCellValue(userList.get(j).getUser_pwd());
                rowUser.createCell(3).setCellValue(userList.get(j).getUser_age());
                rowUser.createCell(4).setCellValue(userList.get(j).getUser_createtime());
                rowUser.createCell(5).setCellValue(userList.get(j).getUser_remark());
            }
        }
        //5.���
        try {
			hwb.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
