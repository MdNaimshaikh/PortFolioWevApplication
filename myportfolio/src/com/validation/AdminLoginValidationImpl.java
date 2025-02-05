package com.validation;

public class AdminLoginValidationImpl implements AdminLoginValidation {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String adminLoginValidation(String username, String password) {
		// TODO Auto-generated method stub
		
		try {
			int userLength = username.length();
			int passwordLength = password.length();
			if(userLength<2 || userLength>20)
			{
				result="invalid username";
			}
			else if(passwordLength<2 || passwordLength>20)
			{
				result="invalid password";
			}
			else{
				result="valid";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="something went wrong";
		}
		finally{
			return result;
			
		}
		
	}

}
