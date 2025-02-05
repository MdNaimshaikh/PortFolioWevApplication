package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ExperiencePojo;

public class ExperienceDaoImpl implements ExperienceDao{


	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;
	
	@SuppressWarnings("finally")
	@Override
	public String insertExperience(String year, String title, String subtitle, String discription, String datetime) {
try {
			
			con=ConnectionFactory.getConnection();
			sql="insert into experience(year,title,subtitle,discription,datetime) values(?,?,?,?,?)";
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
			
				result="saved";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
	public ArrayList<ExperiencePojo> readExperience() {
		//System.out.println("TEST!");
		ArrayList<ExperiencePojo> arrayList = new ArrayList<ExperiencePojo>();
		//System.out.println(arrayList);
		//System.out.println("TEST2");
		try {
			
	
		
		con=ConnectionFactory.getConnection();
		sql="select * from experience";
		ps=con.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		//System.out.println("1333");
		
		while(rs.next())
		{
			
			arrayList.add(new ExperiencePojo(rs.getInt("sn"), rs.getString("year"), rs.getString("title"),
					rs.getString("subtitle"), rs.getString("discription"),rs.getString("datetime")));
			//System.out.println("1");
			//System.out.println("Hi"+arrayList);
			//System.out.println("121");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		arrayList.clear();
	}
	finally
	{
		System.out.println("ee");
		return arrayList;
		
	}
		
	}


	@SuppressWarnings("finally")
	@Override
	public String deleteExperience(int sn) {

		try {
		
			
			con=ConnectionFactory.getConnection();
			sql="delete from experience where sn=?";
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
	public String updateExperience(int sn, String year, String title, String subtitle, String discription,
			String datetime) {
	try {
			
			con=ConnectionFactory.getConnection();
			sql="update experience set year=?, title=?, subtitle=?, discription=?, datetime=? where sn=? ";
			
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
