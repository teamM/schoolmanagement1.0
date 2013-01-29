package com.sms.bo;

import java.util.List;


import com.sms.dao.impl.AddDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AddColumnVO;
import com.sms.vo.TeacherDetailsVO;

public class TeacherDetailsBO {

	AddDetailsDAO dao;
	public void addcolumn(AddColumnVO vo) throws SmsException, SmsBusinessException{
		System.out.println("booo");
		dao = new AddDetailsDAO();
		dao.addColumn(vo);
	}
	public void addteacher(List<String> addTeacher,String table_name,TeacherDetailsVO vo) throws SmsException, SmsBusinessException{

		dao = new AddDetailsDAO();
		boolean addtest=dao.addteacher(addTeacher,table_name);
		if(addtest==true){
			// Random randomGenerator = new Random();
			int minimum=10000000;
			int maximum=99999999;
			int randomNum;
			randomNum = minimum + (int)(Math.random()*maximum);
			vo.setPassword(String.valueOf(randomNum));
			      System.out.println("Generated : "+ randomNum);
			    }
			    dao.generateTPassword(vo);
			    System.out.println("Done.");
			  }
			  
		}
	

