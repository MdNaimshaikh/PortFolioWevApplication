package com.dao;

import java.util.ArrayList;

import com.model.ReadContactPojo;

public interface ContactDao {
	
	public String insertContact(String name , String email, String message,String datetime);
	public ArrayList<ReadContactPojo> readContact();
	public String deleteContact(int sn);

}
