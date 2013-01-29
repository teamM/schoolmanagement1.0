package com.sms.exceptions;

public class SmsBusinessException extends Exception{
			private static final long serialVersionUID = 1L;

		public SmsBusinessException(){
			super();
		}
			
		public SmsBusinessException(String message) {
			super(message);// Calling to the super class constructor
		}
		
	}


