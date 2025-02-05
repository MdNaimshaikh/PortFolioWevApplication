package com.dao;

import java.util.ArrayList;

import com.model.ExperiencePojo;

public interface ExperienceDao {
	
	public String insertExperience(String year,String title,String subtitle,String discription,String datetime);
	public ArrayList<ExperiencePojo> readExperience();
	public String deleteExperience(int sn);
	public String updateExperience(int sn,String year,String title,String subtitle,String discription,String datetime);

}
