package com.service;

import com.model.ReadAdminLoginPojo;

public interface AdminLoginService {
	
	public String adminLoginService(String username, String password);
	public String adminLoginService1(String username, String password);
	public ReadAdminLoginPojo readAdminLoginService();
	public String changeAdminLoginService1(String username,String password);
	public String changeAdminLoginService2(String sn,String username,String password);


}
