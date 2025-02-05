package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.EducationPojo;

public class EducationDaoImpl implements EducationDao {
	

	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;

	@SuppressWarnings("finally")
	@Override
	public String insertEducation(String year, String title, String subtitle, String discription,String datetime) {
try {
			
	System.out.println("D1");
			con=ConnectionFactory.getConnection();
			sql="insert into edu(year,title,subtitle,discription,datetime) values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			System.out.println("d2");
			ps.setString(1,year);
			ps.setString(2,title);
			ps.setString(3,subtitle);
			ps.setString(4,discription);
			ps.setString(5,datetime);
			row=ps.executeUpdate();
			
			if(row==1)
			{
				System.out.println("d3");
				result="saved";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("d4");
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
	public ArrayList<EducationPojo> readEducationS() {
		
		ArrayList<EducationPojo> arrayList = new ArrayList<EducationPojo>();
		try {
	
		
		con=ConnectionFactory.getConnection();
		sql="select * from edu";
		ps=con.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		
		while(rs.next())
		{
			arrayList.add(new EducationPojo(rs.getInt("sn"), rs.getString("year"), rs.getString("title"),
					rs.getString("subtitle"), rs.getString("discription"),rs.getString("datetime")));
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		arrayList.clear();
	}
	finally
	{
		return arrayList;
	}
	}

	@SuppressWarnings("finally")
	@Override
	public String deleteEducation(int sn) {
		
		try {
		
			
			con=ConnectionFactory.getConnection();
			sql="delete from edu where sn=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, sn);
			row=ps.executeUpdate();
			
			
			if(row==1)
			{
				result="delete";
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="SOMETHIG WENT WRONG1";
			
		}
		finally
		{
			return result;
		}
	}
	

	@SuppressWarnings("finally")
	@Override
	public String updateEducation(int sn, String year, String title, String subtitle, String discription,String datetime) {
try {
			
			con=ConnectionFactory.getConnection();
			sql="update edu set year=?, title=?, subtitle=?, discription=?, datetime=? where sn=? ";
			
			ps=con.prepareStatement(sql);
			ps.setString(1,year);
			ps.setString(2,title);
			ps.setString(3,subtitle);
			ps.setString(4,discription);
			ps.setString(5,datetime);
			ps.setInt(6, sn);
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
