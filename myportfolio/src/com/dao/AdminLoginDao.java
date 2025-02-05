package com.dao;

import com.model.ReadAdminLoginPojo;

public interface AdminLoginDao {
	public String readAdminLogin(String username, String password);
	public ReadAdminLoginPojo readAdminLoginData();
	public String changeAdminLoginData(int sn,String username, String password);

}
