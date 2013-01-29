package com.sms.bo;

import java.util.List;

import com.sms.dao.factory.DaoFactory;
import com.sms.dao.impl.SmsAdminDao;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.ExtraVO;
import com.sms.vo.SubjectVO;

public class SmsBO {

	SmsAdminDao dao ;
	
	public List<SubjectVO> retreiveSubjectInfo(SubjectVO vo) throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		List<SubjectVO> subject_list=dao.getSubjectInfo(vo.getStd());		
		return subject_list;		
	}
	
	public List<ExtraVO> retreiveExtraInfo(ExtraVO retvo) throws SmsException,SmsBusinessException {
		dao = (SmsAdminDao) DaoFactory.getInstance();
		List<ExtraVO> extra_list=dao.getExtraInfo(retvo.getStd());
		return extra_list;		
	}
	
	public boolean insertSubjectInfo(SubjectVO addinfo) throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		dao.insertSubjectInfo(addinfo);
		return true;
	}
	
	public boolean insertExtraInfo(ExtraVO addinfo)throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		dao.insertExtraInfo(addinfo);
		return true;
	}
	
	public SubjectVO retreiveEditingSubjectInfo(String sub_code) throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		SubjectVO vo =new SubjectVO();
		vo=dao.retriveEditingSubjectInfo(sub_code);
		return vo;
	}
	
	public ExtraVO retreiveEditingExtraInfo(String extra_code) throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		ExtraVO vo = new ExtraVO();
		vo=dao.retriveEditingExtraInfo(extra_code);
		return vo;
	}
	
	public boolean deleteSubjectInfo(String sub_code) throws SmsException,SmsBusinessException {
		dao = (SmsAdminDao) DaoFactory.getInstance();
		dao.deleteSubjectInfo(sub_code);
		return true;
	}
	
	public boolean deleteExtraInfo(String extra_code) throws SmsException,SmsBusinessException {
		dao = (SmsAdminDao) DaoFactory.getInstance();
		dao.deleteExtraInfo(extra_code);
		return true;
	}
	
	public boolean editSubjectInfo(SubjectVO editinfo) throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		System.out.println("in bo for editing");
		dao.editSubjectInfo(editinfo);
		return true;
	}
	
	public boolean editExtraInfo(ExtraVO editinfo) throws SmsException,SmsBusinessException{
		dao = (SmsAdminDao) DaoFactory.getInstance();
		System.out.println("edit extra BO");
		dao.editExtraInfo(editinfo);
		return true;
	}
		
}
