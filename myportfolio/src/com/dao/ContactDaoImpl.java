package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.ReadContactPojo;

public class ContactDaoImpl implements ContactDao {
	
	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;

	@SuppressWarnings("finally")
	public String insertContact(String name, String email, String message, String datetime) {
		
		try {
			
			con=ConnectionFactory.getConnection();
			sql="insert into contact(name,email,message,datetime) values(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			
			ps.setString(2,email);
			ps.setString(3,message);
			ps.setString(4,datetime);
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
	public ArrayList<ReadContactPojo> readContact() {
		
		ArrayList<ReadContactPojo> arrayList = new ArrayList<ReadContactPojo>();
			try {
		
			
			con=ConnectionFactory.getConnection();
			sql="select * from contact";
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				arrayList.add(new ReadContactPojo(rs.getInt("sn"), rs.getString("name"), rs.getString("email"),
						rs.getString("message"), rs.getString("datetime")));
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
	public String deleteContact(int sn) {

		
		try {
		
			
			con=ConnectionFactory.getConnection();
			sql="delete from contact where sn=?";
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
}
