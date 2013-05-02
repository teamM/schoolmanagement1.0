package com.sms.bo;

import java.util.List;

import com.sms.dao.impl.AssignTeacherDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.SubjectVO;
import com.sms.vo.TeacherDetailsVO;

public class AssignTeacherBO {
	AssignTeacherDAO dao;
	public List<SubjectVO> getsubjectInfo(int std) throws SmsException, SmsBusinessException{
		dao = new AssignTeacherDAO();
		return dao.getsubjectInfo(std);
	}
	
	public List<TeacherDetailsVO> getTeacherInfo() throws SmsException, SmsBusinessException{
		dao = new AssignTeacherDAO();
		return dao.getTeacherInfo();
	} 
	
	public void assignteacher(TeacherDetailsVO tvo) throws SmsException, SmsBusinessException {
		dao = new AssignTeacherDAO();
		dao.assignteachers(tvo);
	}
}
