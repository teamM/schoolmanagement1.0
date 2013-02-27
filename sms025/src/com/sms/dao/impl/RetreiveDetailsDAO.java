package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.SubjectVO;

public class RetreiveDetailsDAO {
	PreparedStatement statement;
	Connection con;
	ResultSet result;
	public RetreiveDetailsDAO() throws SmsException, SmsBusinessException {
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SmsException("Database driver not found");
		}
		catch(SQLException e){
			throw new SmsBusinessException("Connection could not be established");
		}
	}
	
	public List<SubjectVO> retreiveAssignedSubjects(String tid) throws SmsBusinessException{
		List<SubjectVO> subject_list = new ArrayList<SubjectVO>();
		try {
			statement = con.prepareStatement("select * from subject where subject_code in(select code from assignteacher where tid=?)");
			statement.setString(1,tid);
			result = statement.executeQuery();
			SubjectVO vo;
			while(result.next()){
				vo = new SubjectVO();
				vo.setSubjectcode(result.getString(1));
				vo.setSubjectname(result.getString(2));
				vo.setMax_mark(result.getInt(3));
				vo.setPass_mark(result.getInt(4));
				vo.setStd(result.getString(5));
				subject_list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			throw new SmsBusinessException(e+"Subject information could not be retreived");
		}
		return subject_list;		
	}
	
	public List<String> retreiveStudentNames(String std) throws SmsBusinessException{
		List<String> student_list = new ArrayList<String>();
		try {
			statement = con.prepareStatement("select sid from studentdetails where standard=?");
			statement.setString(1, std);
			result = statement.executeQuery();
			while(result.next()){
				student_list.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			throw new SmsBusinessException(e+"Student list could not be retreived");
		}
		return student_list;
	}
	
	public String retreiveStandard(String subject_code) throws SmsBusinessException{
		String std = null;
		try {
			statement = con.prepareStatement("select standard from subject where subject_code=? ");
			statement.setString(1, subject_code);
			result = statement.executeQuery();
			while(result.next()){
				std = result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			throw new SmsBusinessException(e+" Standard info could not be retreived");
		}
		return std;		
	}
	
	public List<String> retreiveTestDetails(String std) throws SmsBusinessException {
		List<String> test_list = new ArrayList<String>();
		try {
			statement = con.prepareStatement("select distinct test_id from testdetails where standard=?");
			statement.setString(1, std);
			System.out.println(std+"std is ");
			result = statement.executeQuery();
			while(result.next()){
				System.out.println(result.getString(1)+" so here ");
				test_list.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			throw new SmsBusinessException(e+" Test Details could not be retreived");
		}		
		return test_list;				
	}
}
