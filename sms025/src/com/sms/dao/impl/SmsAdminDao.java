package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.dao.interfac.Dao;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.ExtraVO;
import com.sms.vo.SubjectVO;

public class SmsAdminDao implements Dao{

	 PreparedStatement statement1,statement2,statement3,statement4,statement5,statement6;
	 PreparedStatement statement7,statement8,statement9,statement10;
	 ResultSet result1,result2;
	 Connection con;
	 
	public SmsAdminDao() throws SmsException,SmsBusinessException {
		System.out.println("daooo");
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
	
		
	public List<SubjectVO> getSubjectInfo(String std) throws SmsBusinessException{
		
		List<SubjectVO> subject_list = new ArrayList<SubjectVO>();
		try {
			statement1=con.prepareStatement("select * from subject where standard=?");		
		statement1.setString(1, std);
		result1=statement1.executeQuery();		
		SubjectVO vo;
		while(result1.next()){
			vo = new SubjectVO();
			System.out.println(result1.getString(1));
			vo.setSubjectcode(result1.getString(1));
			vo.setSubjectname(result1.getString(2));
			vo.setMax_mark(result1.getInt(3));
			vo.setPass_mark(result1.getInt(4));
			vo.setStd(result1.getString(5));
			subject_list.add(vo);
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Subject information could not be retreived");
		}
		return subject_list;
	}
	
	public void insertSubjectInfo(SubjectVO addinfo) throws SmsBusinessException{
		try{
		statement2=con.prepareStatement("insert into subject values(trim(?),trim(?),?,?,?)");
		System.out.println("prepared");
		statement2.setString(1,addinfo.getSubjectcode());
		statement2.setString(2,addinfo.getSubjectname());
		statement2.setInt(3, addinfo.getMax_mark());	
		statement2.setInt(4,addinfo.getPass_mark());
		statement2.setString(5, addinfo.getStd());
		statement2.executeUpdate();
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Subject information could not be inserted");
		}	
	}
	
	public void insertExtraInfo(ExtraVO addinfo) throws SmsBusinessException{
		try{
		System.out.println("inside extra add");
		statement6=con.prepareStatement("insert into extracurricular values(trim(?),trim(?),trim(?))");
		System.out.println("statement prepared");
		System.out.println("prepared");
		statement6.setString(1,addinfo.getExtra_code());
		statement6.setString(2,addinfo.getExtra_name());
		statement6.setString(3, addinfo.getStd());
		statement6.executeUpdate();
		System.out.println("inserted data into extra");
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Extra curricular information could not be inserted");
		}	
	}

	
	public SubjectVO retriveEditingSubjectInfo(String sub_code) throws SmsBusinessException{
		SubjectVO vo = new SubjectVO();
		try{
		statement3=con.prepareStatement("select * from subject where subject_code=?");
		statement3.setString(1,sub_code);
		result2=statement3.executeQuery();		
		while(result2.next()){
			vo.setSubjectcode(result2.getString(1));
			vo.setSubjectname(result2.getString(2));
			vo.setMax_mark(result2.getInt(3));
			vo.setPass_mark(result2.getInt(4));
		}
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Subject information could not be retreived");
		}
		return vo;
		
	}
	
	public ExtraVO retriveEditingExtraInfo(String extra_code) throws SmsBusinessException{
		ExtraVO vo = new ExtraVO();
		try{
		statement8=con.prepareStatement("select * from extracurricular where code=?");
		statement8.setString(1,extra_code);
		result2=statement8.executeQuery();		
		while(result2.next()){
			vo.setExtra_code(result2.getString(1));
			vo.setExtra_name(result2.getString(2));
			}
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Extra curricular information could not be reterived");
		}		
		return vo;
		
	}
	
	public void deleteSubjectInfo(String sub_code) throws SmsBusinessException{
		try{
		statement4=con.prepareStatement("delete from subject where subject_code=?");
		statement4.setString(1, sub_code);
		statement4.executeUpdate();
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Subject information could not be deleted");
		}	
	}
	
	public void deleteExtraInfo(String extra_code) throws SmsBusinessException{
		try{
		statement9=con.prepareStatement("delete from extracurricular where code=?");
		statement9.setString(1, extra_code);
		statement9.executeUpdate();
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Extra curricular information could not be deleted");
		}	
	}
	
	public void editSubjectInfo(SubjectVO editinfo) throws SmsBusinessException{
		try{
		System.out.println("edit smsAdminDao subject");
		statement5=con.prepareStatement("update subject set subject_name=?,maximum_marks=?,pass_marks=?,standard=? where subject_code=?");
		statement5.setString(1,editinfo.getSubjectname());
		statement5.setInt(2, editinfo.getMax_mark());	
		statement5.setInt(3,editinfo.getPass_mark());
		statement5.setString(4, editinfo.getStd());
		statement5.setString(5, editinfo.getSubjectcode());
		System.out.println("edit dao1");
		statement5.executeUpdate();
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Subject information could not be Updated");
		}	
	}
	
	public void editExtraInfo(ExtraVO editinfo) throws SmsBusinessException{
		try{
		System.out.println("edit extra smsAdminDao");
		statement10=con.prepareStatement("update extracurricular set name=? where code=?");
		statement10.setString(1, editinfo.getExtra_name());
		statement10.setString(2, editinfo.getExtra_code());
		statement10.executeUpdate();
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Extra curricular information could not be Updated");
		}	
	}
	
	

	public List<ExtraVO> getExtraInfo(String std) throws SmsBusinessException {
		List<ExtraVO> extra_list = new ArrayList<ExtraVO>();
		try{
		statement7=con.prepareStatement("select * from extracurricular where standard=?");
		statement7.setString(1, std);
		result1=statement7.executeQuery();		
		ExtraVO vo;
		while(result1.next()){
			vo = new ExtraVO();
			vo.setExtra_code(result1.getString(1));
			vo.setExtra_name(result1.getString(2));
			extra_list.add(vo);
		}
		con.close();
		}catch (SQLException e) {
		// TODO Auto-generated catch block
			throw new SmsBusinessException("Extra curricular information could not be retreived");
		}	
		return extra_list;
	}
	
}
