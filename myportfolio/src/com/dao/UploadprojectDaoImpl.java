package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.UploadProjectPojo;

public class UploadprojectDaoImpl implements UploadProjectDao {

	
	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;
	@SuppressWarnings("finally")
	@Override
	public String insertProject(String forfilename, String datetime, Connection con) {
try {
			sql="insert into project(forfilename,datetime) values(?,?)";
			 ps = con.prepareStatement(sql);
			 ps.setString(1, forfilename);
			 ps.setString(2, datetime);
			 
			  row = ps.executeUpdate();
			  
			  if(row==1)
			  {
				  result="saved";
			  }
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			result="failed";
		}
			
		finally
		{
			return result;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public ArrayList<UploadProjectPojo> readProject() {
		
		ArrayList<UploadProjectPojo> arrayList = new ArrayList<UploadProjectPojo>();
		try {
			
			con= ConnectionFactory.getConnection();
			sql="select * from project";
			 ps = con.prepareStatement(sql);
			 rs=ps.executeQuery();
			 
			 while(rs.next())
			 {				 
				 arrayList.add( new UploadProjectPojo(rs.getInt("sn"), rs.getString("forfilename"),
						 rs.getString("datetime")));

			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		finally
		{
			return arrayList;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public String deleteProject(int sn, Connection con) {
try {
			
			con= ConnectionFactory.getConnection();
			sql="delete from project where sn=?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, sn);
			row=ps.executeUpdate();
			
			if(row==1)
			{
				result="deleted";
			}
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			result="failed";
		}
			
		finally
		{
			return result;
		}
	}
	}