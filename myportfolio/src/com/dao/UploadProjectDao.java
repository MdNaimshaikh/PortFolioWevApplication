package com.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.model.UploadProjectPojo;

public interface UploadProjectDao {
	
	public String insertProject(String forfilename,String datetime, Connection con);
	public ArrayList<UploadProjectPojo> readProject();
	public String deleteProject(int sn, Connection con);

}
