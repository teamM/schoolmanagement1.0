package com.sms.dao.factory;

import com.sms.dao.impl.SmsAdminDao;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;

public class DaoFactory {
public static Object getInstance() throws SmsException, SmsBusinessException{
		
		return new SmsAdminDao();
	}
}
