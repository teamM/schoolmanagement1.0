package com.sms.exceptions;

public class SmsException extends Exception{
	

		/**
		 * The serialVersionUID for the serializable class
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Overloaded Constructor
		 * 
		 * @param exception
		 *            -The exception object which got caught.
		 */
		
		/**
		 * Overloaded Constructor
		 * 
		 * @param message
		 *            -The message to be displayed for the particular exception
		 * @param exception
		 *            -The exception object which got caught.
		 */
		
		public SmsException(){
			super();
		}
		
		public SmsException(String message){
			super(message);
		}
		
	}


