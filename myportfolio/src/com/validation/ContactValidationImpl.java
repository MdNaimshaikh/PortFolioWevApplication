package com.validation;

public class ContactValidationImpl implements ContactValidation {

	private String result;

	@SuppressWarnings("finally")
	@Override
	public String contactValidation(String name, String email, String message) {
		try {
		
			int name_len=name.length();
			int email_len=email.length();
			int message_len=message.length();
			System.out.println("ccc2");
			if(name_len <2 || name_len>30)
			{
				result="invalid name length";
			}
			else if(email_len<4 || email_len>30)
			{
				result="invalid email length";
			}
			else if(message_len<5 || message_len>100)
			{
				result="invalid message length";
			}
			else
			{
			
				result="valid";
			}

		} catch (Exception e) {
			
			result="Something went wrong";
			e.printStackTrace();
		} finally {
			return result;
		}
	}

}
