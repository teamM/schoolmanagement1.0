package com.sms.constants;

/**
 * This class contains the constant declarations related to database
 * 
 * @author t-Renjith
 * 
 */
public final class DataBaseConstants {
	private DataBaseConstants(){
		new DataBaseConstants();
	}
	/**
	 * The Database properties file
	 */
	public static final String DBPROPERTIES = "dataBase";
	/**
	 * Data base user name
	 */
	public static final String DATABASEUSERNAME = "database.username";
	/**
	 * Data base password
	 */
	public static final String DATABASEPASSWORD = "database.password";
	/**
	 * The type of data base the application uses
	 */
	public static final String DATABASETYPE = "database.databaseType";
	/**
	 * The SQL query for getting the user details for user validation
	 */
	public static final String QRY_USR_VALIDATE = "select * from users where username =?";
	/**
	 * The query string used for getting the course details for the given
	 * course.Used for validating the existence of the course already in the
	 * system ID
	 */
	public static final String QUERY_COURSE_CODE = "select COURSE_NAME from COURSE_INFO where COURSE_CODE=?";
	/**
	 * Query String for adding course into the system
	 */
	public static final String QUERY_ADDCOURSE = "Insert into COURSE_INFO values(?,?,?,?)";
	/**
	 * SQL query for inserting into COURSE_FEE table
	 */
	public static final String QUERY_ADDFEES = "Insert into COURSE_FEES values(?,?,?,?)";
	/**
	 * The SQL query string for retrieving the COURSEFEE data from the database
	 */
	public static final String QUERY_FEEMASTER = "Select * from COURSE_FEES_MASTER ";
	/**
	 * Select query for getting the course details from the system
	 */
	public static final String QRY_RETRICOURSE = "select * from COURSE_INFO t1 inner join COURSE_FEES t2 on t1.COURSE_CODE=t2.COURSE_CODE where t1.COURSE_CODE=?";;

}
