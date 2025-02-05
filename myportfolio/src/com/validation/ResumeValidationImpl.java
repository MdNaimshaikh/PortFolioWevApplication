package com.validation;

import javax.servlet.http.Part;

public class ResumeValidationImpl implements ResumeValidation{

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String validate(Part part) {

		try {
			//1mb=1024kb
			//1kb=1024b
			//1mb= 1024 * 1024
			
			
			long size = part.getSize();
			String contentType = part.getContentType();
		
			
			if(!contentType.endsWith("pdf"))
			{
				result="invalid Format";
			}
			else if(size>1048576){
				
				result="file size exceeded";
				
			}
			else
			{
				result="valid";
			}
			
//			System.out.println(size);
//			System.out.println(contentType);
			
		} catch (Exception e) {
			result="Something Went Wrong";
			e.printStackTrace();
		}
		finally{
			
			return result;
		}
	}

}
