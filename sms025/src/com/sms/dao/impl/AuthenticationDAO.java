package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AuthenticationVO;

public class AuthenticationDAO {
	PreparedStatement statement;
	Connection con;
	ResultSet result;
	public AuthenticationDAO() throws SmsException, SmsBusinessException {
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
	
	public boolean authenticateUser(AuthenticationVO vo)throws SmsException, SmsBusinessException{
		try{
			statement=con.prepareStatement("select * from teachercredentials where tid=? and password=?");
			statement.setString(1, vo.getUsername());    
			statement.setString(2, vo.getPassword());
			System.out.println(vo.getPassword()+"pass"+vo.getUsername()+"username");
			result=statement.executeQuery();
			
			if(result.next()){
				return true;
			}
			con.close();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				throw new SmsBusinessException(e+"Subject information could not be inserted");
			}	

		
		return false;
		
	}

}
