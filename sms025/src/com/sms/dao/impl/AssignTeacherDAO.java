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
import com.sms.vo.TeacherDetailsVO;

public class AssignTeacherDAO {
	PreparedStatement statement;
	Connection con;
	ResultSet result;
	
	public AssignTeacherDAO() throws SmsException, SmsBusinessException {
		// TODO Auto-generated constructor stub
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
	
	public List<SubjectVO> getsubjectInfo(int std) throws SmsException, SmsBusinessException{
		List<SubjectVO> subject_list = new ArrayList<SubjectVO>();
		if(std==0){
			throw new SmsBusinessException("Please choose the correct option");
		}
		try {
			statement = con.prepareStatement("select subject_code,subject_name from subject where standard=? and subject_code not in(select code from assignteacher);");		
			statement.setInt(1, std);
			result = statement.executeQuery();		
			SubjectVO vo;
			while(result.next()){
				vo = new SubjectVO();			
				vo.setSubjectcode(result.getString(1));
				vo.setSubjectname(result.getString(2));		
				subject_list.add(vo);
			}
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new SmsBusinessException("Subject information could not be retreived");
			}
			return subject_list;
		}
	
	public List<TeacherDetailsVO> getTeacherInfo() throws SmsException, SmsBusinessException{
		List<TeacherDetailsVO> teacher_list = new ArrayList<TeacherDetailsVO>();
		try {
			statement = con.prepareStatement("select * from teacherdetails");				
			result = statement.executeQuery();		
			TeacherDetailsVO vo;
			while(result.next()){
				vo = new TeacherDetailsVO();			
				vo.setTid(result.getString(1));
				vo.setTeacher_name(result.getString(2));
				teacher_list.add(vo);
			}
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new SmsBusinessException("teacher details could not be retreived");
			}
			return teacher_list;
		}
	
	public void assignteachers(TeacherDetailsVO tvo) throws SmsBusinessException {
		String tid = tvo.getTid();
		String[] subject_codes = tvo.getSubject_code();
		try {
				for(int i=0;i<subject_codes.length;i++){
				statement = con.prepareStatement("insert into assignteacher values(?,?)");
				statement.setString(1, subject_codes[i]);
				statement.setString(2, tid);
				//statement.setString(3, "2");
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e+"error is here");
			throw new SmsBusinessException("Teacher could not be assigned to the subjects");
			
		}
	}
}
