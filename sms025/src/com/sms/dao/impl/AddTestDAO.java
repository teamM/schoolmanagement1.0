package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AddTestVO;

public class AddTestDAO {
	PreparedStatement statement;
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
		try{
			statement=con.prepareStatement("insert into testdetails values(trim(?),trim(?),?,?,?,trim(?))");
			statement.setString(1,vo.getTestid());
			statement.setString(2,vo.getTestname());
			statement.setString(3, vo.getStd());	
			statement.setInt(4,vo.getMaxmarks());
			statement.setInt(5,vo.getPassmarks());
			statement.setString(6, vo.getSubject_code());
			statement.executeUpdate();
			con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new SmsBusinessException("Subject information could not be inserted");
			}	
		}
	}
