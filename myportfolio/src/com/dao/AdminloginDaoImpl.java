package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.ReadAdminLoginPojo;

public class AdminloginDaoImpl implements AdminLoginDao {

	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;
	@SuppressWarnings("finally")
	@Override
	public String readAdminLogin(String username, String password) {
		// TODO Auto-generated method stub
		try {
		
			con=ConnectionFactory.getConnection();
			sql="select * from adminlogin where username=? and password=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result="exist";
				
			}
			else
			{
				result="not exist";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="something went wrong";
		}
		finally
		{
			return result;	
		}
		
	}
	@SuppressWarnings("finally")
	public ReadAdminLoginPojo readAdminLoginData() {
		
		ReadAdminLoginPojo readAdminLoginPojo =null;
		try {
			
			con=ConnectionFactory.getConnection();
			sql="select * from adminlogin ";
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			readAdminLoginPojo = new ReadAdminLoginPojo(rs.getInt("sn"), rs.getString("username"), rs.getString("password"));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="something went wrong";
		}
		finally
		{
			return readAdminLoginPojo;	
		}
		
	}
	@SuppressWarnings("finally")
	@Override
	public String changeAdminLoginData(int sn, String username, String password) {
try {
			
			con=ConnectionFactory.getConnection();
			sql="update  adminlogin set username=?, password=? where sn=? ";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, sn);
			row=ps.executeUpdate();

				if(row==1)
				{
					result="updated";
				}
				
			
		}
			catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="failed";
		}
		finally
		{
			return result;	
		}
		
	}

}
