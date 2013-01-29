package com.sms.delegate;

import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.facade.SmsAdminFacade;
import com.sms.locator.Locator;
import com.sms.vo.ExtraVO;
import com.sms.vo.SubjectVO;
import java.util.List;

public class SmsDelegate {

		public List<SubjectVO> retreiveSubjectDelegate(SubjectVO vo) throws SmsException, SmsBusinessException{
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");
			return admin_facade.retreiveSubjectDelegate(vo);
		}
	
		public boolean insertSubjectDelegate(SubjectVO vo) throws SmsException, SmsBusinessException{		
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");								
			return admin_facade.insertSubjectInfo(vo);			
		}
		
		public boolean editSubjectDelegate(SubjectVO vo) throws SmsException, SmsBusinessException{			
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");									
			return admin_facade.editSubjectInfo(vo);			
		}
		
		public boolean deletesubjectDelegate(String sub_code) throws SmsException, SmsBusinessException{			
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");			
			return admin_facade.deleteSubjectInfo(sub_code);			
		}
		
		public SubjectVO retreiveEditingSubjectDelegate(String sub_code) throws SmsException, SmsBusinessException{
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");			
			return admin_facade.retreiveEditingSubjectInfo(sub_code);			
			
		}
		
		/*---------------------------*/
		
		public List<ExtraVO> retreiveExtraDelegate(ExtraVO vo) throws SmsException, SmsBusinessException{
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");
			return admin_facade.retreiveExtraDelegate(vo);
		}
	
		public boolean insertExtraDelegate(ExtraVO vo) throws SmsException, SmsBusinessException{		
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");			
			return admin_facade.insertExtraInfo(vo);			
		}
		
		public boolean editExtraDelegate(ExtraVO vo) throws SmsException, SmsBusinessException{			
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");									
			return admin_facade.editExtraInfo(vo);			
		}
		
		public boolean deleteExtraDelegate(String sub_code) throws SmsException, SmsBusinessException{			
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");									
			return admin_facade.deleteExtraInfo(sub_code);			
		}
		
		public ExtraVO retreiveEditingExtraDelegate(String extra_code) throws SmsException, SmsBusinessException{
			SmsAdminFacade admin_facade =(SmsAdminFacade) new Locator().locate("subject");			
			return admin_facade.retreiveEditingExtraInfo(extra_code);			
			
		}
		
	   
	}

