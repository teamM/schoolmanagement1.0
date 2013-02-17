package com.sms.bo;

import java.util.List;

import com.sms.dao.impl.AddTestDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AddTestVO;

public class AddTestBO {
	AddTestDAO dao;
	public void addtest(AddTestVO vo) throws SmsException, SmsBusinessException{
		dao = new AddTestDAO();
		dao.AddTest(vo);
	}
	
	public List<AddTestVO> retreiveTestDetails(String std) throws SmsException, SmsBusinessException {
		dao = new AddTestDAO();
		return dao.retreiveTestDetails(std);
	}
}
