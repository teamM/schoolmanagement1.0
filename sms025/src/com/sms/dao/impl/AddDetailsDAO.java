package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AccountVO;
import com.sms.vo.AddColumnVO;
import com.sms.vo.TeacherDetailsVO;

public class AddDetailsDAO {

	PreparedStatement addcolumn_statement=null,teachertable_statement,addteacher_statement,addaccount_statement,generatepassword_statement;
	Connection con;
	ResultSet result;
	public AddDetailsDAO() throws SmsException, SmsBusinessException {
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
	
	public void addColumn(AddColumnVO vo){
		String exe_statem = null;
		String datatype = vo.getNewdatatype();
		System.out.println(datatype);
		if(datatype.equalsIgnoreCase("char")){
			exe_statem = "alter table "+vo.getTable_name()+" add " + vo.getNewcolumn() + " varchar(30)";
		}
		else if(datatype.equalsIgnoreCase("number")){
			System.out.println("xxxxxxxx");
			exe_statem = "alter table "+vo.getTable_name()+" add " + vo.getNewcolumn() + " int(10)";
			System.out.println(exe_statem);
		}
		else if(datatype.equalsIgnoreCase("date")){
			exe_statem = "alter table "+vo.getTable_name()+" add " + vo.getNewcolumn() + " date";
		}
		try {	
			addcolumn_statement = con.prepareStatement(exe_statem);
			addcolumn_statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addteacher(List<String> addTeacher,String table_name){
		System.out.println("yyyyyy");
		boolean addtest = false;
		String add="insert into ";
		add+=table_name+" values(";
		Iterator<String> io = addTeacher.iterator();
		while(io.hasNext()){
			String d=io.next();
			System.out.println(d);
			add+="'"+d+"',";
		
		try {
			add=add.substring(0,add.length()-1)+")";
			System.out.println(add);
			addteacher_statement= con.prepareStatement(add);
			addteacher_statement.executeUpdate();
			addtest=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addtest=false;
		}
	
		}
		return addtest;
	}
	
	public void generateTPassword(TeacherDetailsVO vo) throws SmsBusinessException,SmsException{
		try{
			generatepassword_statement=con.prepareStatement("insert into teachercredentials values(trim(?),trim(?),trim(?))");
			generatepassword_statement.setString(1,vo.getTid());
			generatepassword_statement.setString(2,vo.getTid());
			generatepassword_statement.setString(3,vo.getPassword());
			generatepassword_statement.executeUpdate();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SmsBusinessException("Subject information could not be inserted");
		}
	}
	
	public List<String> retreiveTeacherTable(String table_name){
		List<String> teacher_list = new ArrayList<String>();
		String table_fetch="select column_name from information_schema.columns where table_name='" + table_name + "' order by ordinal_position";
		try {
			
			teachertable_statement = con.prepareStatement(table_fetch);
			result = teachertable_statement.executeQuery();
			while(result.next()){
				teacher_list.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher_list;	
	}
	public void addAccountDetails(AccountVO accvo) throws SmsBusinessException{

		try{
			addaccount_statement=con.prepareStatement("insert into accountdetails values(trim(?),trim(?),trim(?))");
			System.out.println("prepared");
			addaccount_statement.setString(1,accvo.getAccountcode());
			addaccount_statement.setString(2,accvo.getTypedescription());
			addaccount_statement.setString(3,accvo.getCategory());	
			addaccount_statement.executeUpdate();
			con.close();
	}catch(SQLException e){
		throw new SmsBusinessException("Account information could not be inserted");
	}
}
}
