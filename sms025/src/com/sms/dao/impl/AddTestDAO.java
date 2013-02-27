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
import com.sms.vo.AddTestVO;

public class AddTestDAO {
	PreparedStatement statement,statement_create;
	Connection con;
	ResultSet result;
	public AddTestDAO() throws SmsException, SmsBusinessException {
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
	public void AddTest(AddTestVO vo) throws SmsException, SmsBusinessException{
		String query_create = "create table " + vo.getTestid() +"_table(test_id varchar(10),subject_code varchar(10),student_name varchar(30),marks_secured int(3),foreign key(test_id) references testdetails(test_id))";
		try{
			statement=con.prepareStatement("insert into testdetails values(trim(?),trim(?),?,?,?)");
			statement.setString(1,vo.getTestid());
			statement.setString(2,vo.getTestname());
			statement.setString(3, vo.getStd());	
			statement.setInt(4,vo.getMaxmarks());
			statement.setInt(5,vo.getPassmarks());			
			statement.executeUpdate();
			
			//creating the table to enter marks details
			statement_create = con.prepareStatement(query_create);
			statement_create.executeUpdate();
			con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				throw new SmsBusinessException("Subject information could not be inserted");
			}	
		}
	public List<AddTestVO> retreiveTestDetails(String std) throws SmsBusinessException{
		List<AddTestVO> test_list = new ArrayList<AddTestVO>();
		AddTestVO vo;
		try {
			statement = con.prepareStatement("select * from testdetails where standard=?");
			statement.setString(1, std);
			result = statement.executeQuery();
			while(result.next()){
				vo = new AddTestVO();
				vo.setTestid(result.getString(1));
				vo.setTestname(result.getString(2));
				vo.setStd(result.getString(3));
				vo.setMaxmarks(result.getInt(4));
				vo.setPassmarks(result.getInt(5));
				test_list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SmsBusinessException("Test details could not be retreived");
		}
		return test_list;		
		}
	}
