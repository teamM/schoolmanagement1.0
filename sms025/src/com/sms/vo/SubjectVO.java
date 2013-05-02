package com.sms.vo;

public class SubjectVO {
	
	private String type;
	private String std;
	private String subjectcode;
	private String subjectname;
	private int max_mark;
	private int pass_mark;	
	
	
	private String excode;
	private String exname;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public int getPass_mark() {
		return pass_mark;
	}
	public void setPass_mark(int pass_mark) {
		this.pass_mark = pass_mark;
	}
	public int getMax_mark() {
		return max_mark;
	}
	public void setMax_mark(int max_mark) {
		this.max_mark = max_mark;
	}
	public String getExcode() {
		return excode;
	}
	public void setExcode(String excode) {
		this.excode = excode;
	}
	public String getExname() {
		return exname;
	}
	public void setExname(String exname) {
		this.exname = exname;
	}
	
	
}
