package com.service;

import java.util.ArrayList;

import com.model.ReadContactPojo;

public interface ContactService1 {
	
	public String contactService1(String name , String email, String message);
	public String contactService2(String name , String email, String message);
	public ArrayList<ReadContactPojo> readContactService();
	public String deleteService(String sn);

}
