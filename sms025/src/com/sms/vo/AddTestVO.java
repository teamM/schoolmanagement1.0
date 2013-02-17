package com.sms.vo;

public class AddTestVO {
	
private String testid;
private String testname;
private int maxmarks;
private int passmarks;
private String std;
private String subject_code;

public String getSubject_code() {
	return subject_code;
}
public void setSubject_code(String subject_code) {
	this.subject_code = subject_code;
}
public String getTestid() {
	return testid;
}
public void setTestid(String testid) {
	this.testid = testid;
}
public String getTestname() {
	return testname;
}
public void setTestname(String testname) {
	this.testname = testname;
}
public int getMaxmarks() {
	return maxmarks;
}
public void setMaxmarks(int maxmarks) {
	this.maxmarks = maxmarks;
}
public int getPassmarks() {
	return passmarks;
}
public void setPassmarks(int passmarks) {
	this.passmarks = passmarks;
}
public String getStd() {
	return std;
}
public void setStd(String std) {
	this.std = std;
}
}
