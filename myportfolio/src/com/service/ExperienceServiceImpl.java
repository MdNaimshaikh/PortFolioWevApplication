package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.dao.EducationDaoImpl;
import com.dao.ExperienceDaoImpl;
import com.model.ExperiencePojo;
import com.validation.EducationValidationImpl;
import com.validation.ExperienceValidationImpl;

public class ExperienceServiceImpl implements ExperienceService {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String saveExperienceService1(String year, String title, String subtitle, String discription) {

		try {
			System.out.println("service1");

			ExperienceValidationImpl experienceValidationImpl=new ExperienceValidationImpl();
			result=	experienceValidationImpl.experienceValidation(year, title, subtitle, discription);
		
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
	public String saveExperienceService2(String year, String title, String subtitle, String discription) {
		try {
			String datetime=LocalDateTime.now().toString();
		result=	new ExperienceDaoImpl().insertExperience(year, title, subtitle, discription, datetime);
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
	public String deleteExperienceService(String sn) {
try{
			
			int getsn=Integer.parseInt(sn);
			
			ExperienceDaoImpl experienceDaoImpl=new ExperienceDaoImpl();
			
			 result=experienceDaoImpl.deleteExperience(getsn);
					
				}
			catch(Exception e)
				{
				result="service error";
					e.printStackTrace();
				}

				return result;
		}
//	@Override
//	public ArrayList<ExperiencePojo> readExperienceService() {
//		System.out.println("Test5**");
//		ExperienceDaoImpl experienceDaoImpl= new ExperienceDaoImpl();
//		System.out.println("Test5");
//		return experienceDaoImpl.readExperience();
//	}


	@Override
	public ArrayList<ExperiencePojo> readExperienceService() {
		System.out.println("Test4");
		System.out.println("Test4**");
		return new ExperienceDaoImpl().readExperience();
	}

	@SuppressWarnings("finally")
	@Override
	public String updateExperienceService(String sn, String year, String title, String subtitle, String discription) {
		
		try{
			
			int getsn=Integer.parseInt(sn);
			String datetime=LocalDateTime.now().toString();
			ExperienceDaoImpl experienceDaoImpl =new ExperienceDaoImpl();
		result=experienceDaoImpl.updateExperience(getsn, year, title, subtitle, discription, datetime);
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
