package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.ContactDaoImpl;
import com.model.ReadContactPojo;
import com.validation.ContactValidationImpl;

public class ContactService1Impl implements ContactService1 {
	
	private String result;

	@SuppressWarnings("finally")
	@Override
	public String contactService1(String name , String email, String message) {
		
		try {
			ContactValidationImpl contactValidationImpl=new ContactValidationImpl();
			
			 result=contactValidationImpl.contactValidation(name, email, message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
		return result;
		}
	}
@SuppressWarnings("finally")
public String contactService2(String name , String email, String message) {
		
		try {
			String datetime=LocalDateTime.now().toString();
		result=	new ContactDaoImpl().insertContact(name, email, message, datetime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="error";
		}
		finally
		{
		return result;
		}
	}
@Override
public ArrayList<ReadContactPojo> readContactService() {

	return new ContactDaoImpl().readContact();
}
@Override
public String deleteService(String sn) {

	try{
	
	int intsn=Integer.parseInt(sn);
	 ContactDaoImpl contactDaoImpl= new ContactDaoImpl();
	
	 result=contactDaoImpl.deleteContact(intsn);
			
		}
	catch(Exception e)
		{
		result="service error";
			e.printStackTrace();
		}

		return result;

}
	
	

}
