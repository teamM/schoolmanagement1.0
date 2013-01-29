package com.sms.vo;

public class TeacherDetailsVO {
	private String tid;
	private String teacher_name;
	private String[] subject_code;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String[] subject_code) {
		this.subject_code = subject_code;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	

}
