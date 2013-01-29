package com.sms.dao.interfac;

import java.util.List;

import com.sms.exceptions.SmsBusinessException;
import com.sms.vo.ExtraVO;
import com.sms.vo.SubjectVO;

public interface Dao {
	public List<SubjectVO> getSubjectInfo(String std) throws SmsBusinessException;
	public void insertSubjectInfo(SubjectVO addinfo) throws SmsBusinessException;
	public void insertExtraInfo(ExtraVO addinfo) throws SmsBusinessException;
	public SubjectVO retriveEditingSubjectInfo(String sub_code) throws SmsBusinessException;
	public ExtraVO retriveEditingExtraInfo(String extra_code) throws SmsBusinessException;
	public void deleteSubjectInfo(String sub_code) throws SmsBusinessException;
	public void deleteExtraInfo(String extra_code) throws SmsBusinessException;
	public void editSubjectInfo(SubjectVO editinfo) throws SmsBusinessException;
	public void editExtraInfo(ExtraVO editinfo) throws SmsBusinessException;
	public List<ExtraVO> getExtraInfo(String std) throws SmsBusinessException;
	
}
