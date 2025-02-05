package com.service;

import java.util.ArrayList;

import com.model.EducationPojo;

public interface EducationService {
	
	public String saveEducationService1(String year,String title,String subtitle,String discription);
	public String saveEducationService2(String year,String title,String subtitle,String discription);
	public String deleteEducationService(String sn);
	public ArrayList<EducationPojo> readEducationService();
	public String updateEducationService(String sn,String year,String title,String subtitle,String discription);

}
