package com.sms.bo;

import com.sms.dao.impl.AuthenticationDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AuthenticationVO;

public class AuthenticatinBO {

	/**
	 * @param args
	 * @throws SmsBusinessException 
	 * @throws SmsException 
	 */
	public boolean authenticateUser(AuthenticationVO vo) throws SmsException, SmsBusinessException{
		AuthenticationDAO dao=new AuthenticationDAO();
		return dao.authenticateUser(vo);
		
	}

}
