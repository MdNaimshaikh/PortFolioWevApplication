package com.service;

import javax.servlet.http.Part;

import com.fileio.UploadResumeIoImpl;
import com.validation.ResumeValidationImpl;

public class UploadResumeServiceImpl implements UploadResumeService{

	private boolean boolresult;
	private String result;

	public String uploadResumeService(Part part) {
		
		result = new ResumeValidationImpl().validate(part);

		if(result.equals("valid")){
		try {
			UploadResumeIoImpl uploadResumeIoImpl = new UploadResumeIoImpl();
		 boolresult = uploadResumeIoImpl.isExist();
		
		if(boolresult)
		{
				//update : delete then write
				 boolresult = uploadResumeIoImpl.deleteResume();
				
				if(boolresult)
				{
					 result = uploadResumeIoImpl.writeResume(part);
					 if(result.equals("uploaded"))
					 {
						 result="Resume Updated Successfully";
					 }
				}
			}
			else{
				//insert : write
				 result = uploadResumeIoImpl.writeResume(part);
				 if(result.equals("uploaded"))
				 {
					 result="Resume uploaded Successfully";
				 }
			}
			
		} catch (Exception e) {
			
			result="Service Error";
		}
	}
	
	return result;
	
	
	}
}
