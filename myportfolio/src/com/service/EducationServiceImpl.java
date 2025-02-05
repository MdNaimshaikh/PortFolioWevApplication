package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.ContactDaoImpl;
import com.dao.EducationDaoImpl;
import com.model.EducationPojo;
import com.validation.EducationValidationImpl;

public class EducationServiceImpl implements EducationService {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String saveEducationService1(String year, String title, String subtitle, String discription) {
		
		try {
			System.out.println("service1");

			EducationValidationImpl educationValidationImpl=new EducationValidationImpl();
			result=	educationValidationImpl.educationValidation(year, title, subtitle, discription);
		
		System.out.println("service11");
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
	@Override
	public String saveEducationService2(String year, String title, String subtitle, String discription) {
		try {
			String datetime=LocalDateTime.now().toString();
		result=	new EducationDaoImpl().insertEducation(year, title, subtitle, discription, datetime);
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
	public String deleteEducationService(String sn) {
		try{
			
			int getsn=Integer.parseInt(sn);
			
			EducationDaoImpl educationDaoImpl = new EducationDaoImpl();
			
			 result=educationDaoImpl.deleteEducation(getsn);
					
				}
			catch(Exception e)
				{
				result="service error";
					e.printStackTrace();
				}

				return result;

		}

	@Override
	public ArrayList<EducationPojo> readEducationService() {
		// TODO Auto-generated method stub
		System.out.println("Edu1");
		System.out.println(new EducationDaoImpl().readEducationS());
		return new EducationDaoImpl().readEducationS();
	}

	@SuppressWarnings("finally")
	@Override
	public String updateEducationService(String sn, String year, String title, String subtitle, String discription) 
	{
			try{
			
			int getsn=Integer.parseInt(sn);
			String datetime=LocalDateTime.now().toString();
			EducationDaoImpl educationDaoImpl = new EducationDaoImpl();
		result=educationDaoImpl.updateEducation(getsn, year, title, subtitle, discription, datetime);
				}
			catch(Exception e)
				{
				result="service error";
					e.printStackTrace();
				}
			finally{
				return result;
			}

				
	}


}
