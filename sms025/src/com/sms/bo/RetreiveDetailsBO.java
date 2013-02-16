package com.sms.bo;

import java.util.List;

import com.sms.dao.impl.RetreiveDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;

public class RetreiveDetailsBO {

	public List<String> retreiveStudentNames(String std) throws SmsBusinessException, SmsException{
		List<String> student_list;
		RetreiveDetailsDAO dao = new RetreiveDetailsDAO();
		student_list = dao.retreiveStudentNames(std);
		
		return student_list;
	}
	
	public String retreiveStandard(String subject_code) throws SmsException, SmsBusinessException{
		String std;
		RetreiveDetailsDAO dao = new RetreiveDetailsDAO();
		std = dao.retreiveStandard(subject_code);
		return std;
	}
	
	public List<String> retreiveTestDetails(String std) throws SmsException, SmsBusinessException{
		RetreiveDetailsDAO dao = new RetreiveDetailsDAO();
		return dao.retreiveTestDetails(std);
	}
}
