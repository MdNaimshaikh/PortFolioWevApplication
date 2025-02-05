package com.validation;

public class ExperienceValidationImpl implements ExperienceValidation {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String experienceValidation(String year, String title, String subtitle, String discription) {
try {
			
			int year_length=year.length();
			
			int title_len=title.length();
			
			int subtitle_len=subtitle.length();
			
			int discription_len=discription.length();
			
			if(year_length!=4)
			{
				result="Year length invalid";
			}
			else if(title_len<5 || title_len>30)
			{
				result="Title length invalid";
			}
			else if(subtitle_len<5 || subtitle_len>45)
			{
				result="Subtitle length invalid";
			}
			else if(discription_len<10 ||discription_len>100)
			{
				result="discription length invalid";
			}
			else
			{
				
				result="valid";
			}
			
		} 
		
		catch (Exception e) {
		
			
			result="something went wrong";
			e.printStackTrace();
			
		}
		finally{
			return result;
			
		}
		
	}

}