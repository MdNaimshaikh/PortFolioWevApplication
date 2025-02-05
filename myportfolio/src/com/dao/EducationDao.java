package com.dao;

import java.util.ArrayList;

import com.model.EducationPojo;

public interface EducationDao {
	
	public String insertEducation(String year,String title,String subtitle,String discription,String datetime);
	public ArrayList<EducationPojo> readEducationS();
	public String deleteEducation(int sn);
	public String updateEducation(int sn,String year,String title,String subtitle,String discription,String datetime);

}
