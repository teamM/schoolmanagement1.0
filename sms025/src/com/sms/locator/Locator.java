package com.sms.locator;

import com.sms.facade.SmsAdminFacade;

public class Locator {

		public Object locate(String location){
			System.out.println("in locator");
			Object obj=null;
			if(location.equalsIgnoreCase("subject")){
				obj=new SmsAdminFacade();
			}			
			return obj;
		}
}
