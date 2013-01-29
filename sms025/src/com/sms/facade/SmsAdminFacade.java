package com.sms.facade;

import com.sms.bo.SmsBO;
import java.util.List;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.ExtraVO;
import com.sms.vo.SubjectVO;

public class SmsAdminFacade {

	public List<SubjectVO> retreiveSubjectDelegate(SubjectVO vo) throws SmsException, SmsBusinessException{
		SmsBO bo=new SmsBO();		
		return bo.retreiveSubjectInfo(vo);
	}
	
	public boolean insertSubjectInfo(SubjectVO vo) throws SmsException,SmsBusinessException{				
		    	System.out.println("in subject facade");		    
		    		SmsBO bo=new SmsBO();			
				return bo.insertSubjectInfo(vo);				
			}
	
	public boolean editSubjectInfo(SubjectVO vo) throws SmsException,SmsBusinessException{
		    	System.out.println("in subject facade");		    
		    		SmsBO bo=new SmsBO();		        				
				return bo.editSubjectInfo(vo);				
			}
	public boolean deleteSubjectInfo(String sub_code) throws SmsException,SmsBusinessException{		
		    	System.out.println("in subject facade");		    
		    		SmsBO bo=new SmsBO();		        				
				return bo.deleteSubjectInfo(sub_code);				
			}
	
	public SubjectVO retreiveEditingSubjectInfo(String sub_code) throws SmsException,SmsBusinessException{		
    	System.out.println("in subject facade");		    
    		SmsBO bo=new SmsBO();		        				
		return bo.retreiveEditingSubjectInfo(sub_code);				
	}
	/*---------------------------------------------------------*/
	
	public List<ExtraVO> retreiveExtraDelegate(ExtraVO vo) throws SmsException, SmsBusinessException{
		SmsBO bo=new SmsBO();		
		return bo.retreiveExtraInfo(vo);
	}
	
	public boolean insertExtraInfo(ExtraVO vo) throws SmsException,SmsBusinessException{				
		    	System.out.println("in subject facade");		    
		    		SmsBO bo=new SmsBO();			
				return bo.insertExtraInfo(vo);				
			}
	
	public boolean editExtraInfo(ExtraVO vo) throws SmsException,SmsBusinessException{
		    	System.out.println("in subject facade");		    
		    		SmsBO bo=new SmsBO();		        				
				return bo.editExtraInfo(vo);				
			}
	public boolean deleteExtraInfo(String sub_code) throws SmsException,SmsBusinessException{		
		    	System.out.println("in subject facade");		    
		    		SmsBO bo=new SmsBO();		        				
				return bo.deleteExtraInfo(sub_code);				
			}
	
	public ExtraVO retreiveEditingExtraInfo(String sub_code) throws SmsException,SmsBusinessException{		
    	System.out.println("in subject facade");		    
    		SmsBO bo=new SmsBO();		        				
		return bo.retreiveEditingExtraInfo(sub_code);				
	}
	

	}


