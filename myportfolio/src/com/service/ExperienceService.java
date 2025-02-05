package com.service;

import java.util.ArrayList;

import com.model.EducationPojo;
import com.model.ExperiencePojo;

public interface ExperienceService {
	
	public String saveExperienceService1(String year,String title,String subtitle,String discription);
	public String saveExperienceService2(String year,String title,String subtitle,String discription);
	public String deleteExperienceService(String sn);
	public ArrayList<ExperiencePojo> readExperienceService();
	public String updateExperienceService(String sn,String year,String title,String subtitle,String discription);

}
