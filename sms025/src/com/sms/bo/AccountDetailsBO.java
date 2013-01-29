package com.sms.bo;

import com.sms.dao.impl.AddDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AccountVO;

public class AccountDetailsBO {
	AddDetailsDAO dao;
	public void addaccountdetails(AccountVO vo) throws SmsException, SmsBusinessException{
		System.out.println("booo");
		dao = new AddDetailsDAO();
		dao.addAccountDetails(vo);
	}
	
}