package com.service;

import com.dao.AdminloginDaoImpl;
import com.model.ReadAdminLoginPojo;
import com.validation.AdminLoginValidationImpl;

public class AdminLoginServiceImpl implements AdminLoginService{

		private String result;
	@SuppressWarnings("finally")
	@Override
	public String adminLoginService(String username, String password) {
		// TODO Auto-generated method stub
		
		//System.out.println("****");
		try {
			AdminLoginValidationImpl adminLoginValidatiomimpl=new AdminLoginValidationImpl();
		  result=adminLoginValidatiomimpl.adminLoginValidation(username, password);
		
		  //System.out.println("****1");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Something went Wrong";
		}
		finally{
			return result;
		}
		
	}
	@SuppressWarnings("finally")
	@Override
	public String adminLoginService1(String username, String password) {
		try {
			
		AdminloginDaoImpl adminloginDaoImpl=new AdminloginDaoImpl();
		result=adminloginDaoImpl.readAdminLogin(username, password);
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Something went Wrong";
		}
		finally{
			return result;
		}
		
	}
	@SuppressWarnings("finally")
	@Override
	public ReadAdminLoginPojo readAdminLoginService() {
		ReadAdminLoginPojo readAdminLoginData =null;
		try {
			AdminloginDaoImpl adminloginDaoImpl = new AdminloginDaoImpl();
			readAdminLoginData = adminloginDaoImpl.readAdminLoginData();
		} catch (Exception e) {
			
			e.printStackTrace();
			result="Something went Wrong";
		}
		finally{
			return readAdminLoginData;
		}
	}
	@SuppressWarnings("finally")
	public String changeAdminLoginService1(String username,String password) {
		try {
		result=new AdminLoginValidationImpl().adminLoginValidation(username, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		finally{
			return result;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public String changeAdminLoginService2(String sn, String username, String password) {
		try {
			result=new AdminloginDaoImpl().changeAdminLoginData(Integer.parseInt(sn), username, password);
			} catch (Exception e) {
				
				e.printStackTrace();
			 result="Something went wrong";
			}
			finally{
				return result;
			}
		}
}
