package com.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.http.Part;

import com.dao.ConnectionFactory;
import com.dao.UploadprojectDaoImpl;
import com.fileio.ProjectIoImpl;
import com.validation.UploadProjectValidationImpl;

public class UploadProjectServiceImpl implements UploadProjectService {

	private String result;
	@SuppressWarnings("finally")
	@Override
	public String uploadProjectService1(Part part) {
		
		try {
			
			//System.out.println("******S");
			// Validation
			UploadProjectValidationImpl uploadProjectValidationImpl = new UploadProjectValidationImpl();
			result=uploadProjectValidationImpl.projectValidation(part);
			
		} catch (Exception e) {
			// TODO: handle exception
			result="Something Went Wrong";
			e.printStackTrace();
		}
		finally{
			return result;
		}
		
	}
	@SuppressWarnings("finally")
	@Override
	public String uploadProjectService2(Part part, String datetime) {

		try {
			
			String submittedFileName = part.getSubmittedFileName();
			
			String datetime2=LocalDateTime.now().toString();
			//System.out.println(datetime2);
			String[] split = datetime2.split(":");
			String fordatetime2=split[0]+split[1]+split[2];
			
		String forfilename=	fordatetime2+submittedFileName;
		
		System.out.println(datetime2);
		
		//Dao
		
		Connection con=ConnectionFactory.getConnection();
		con.setAutoCommit(false);
		
		UploadprojectDaoImpl uploadprojectDaoImpl = new UploadprojectDaoImpl();
		this.result=uploadprojectDaoImpl.insertProject(forfilename, datetime, con);
		
		if(result.equals("saved"))
		{
			//File Io
			
			ProjectIoImpl projectIoImpl = new ProjectIoImpl();
			boolean result = projectIoImpl.writeProject(part, forfilename);
			
			if(result)
			{
				con.commit();
				this.result="Project Uplosded SuccessFully";
			}
			else{
				con.rollback();
				this.result="Something Went Wrong";
			}
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
			this.result="Something Went Wrong";
			e.printStackTrace();
		}
		finally{
			return this.result;
		}
		
	}
	
	
	@SuppressWarnings("finally")
	@Override
	public String deleteProjectService(String sn, String forfilename) {
		Connection con = ConnectionFactory.getConnection();
try {
			int getsn=Integer.parseInt(sn);
			
			 con.setAutoCommit(false);
			
			//delete from DB 
			UploadprojectDaoImpl daoImpl=new UploadprojectDaoImpl();
			this.result=daoImpl.deleteProject(getsn, con);
			
			if(this.result.equals("deleted"))
			{
				//fileIo 
				ProjectIoImpl projectIoImpl = new ProjectIoImpl();
				boolean result = projectIoImpl.daleteProject(forfilename);
				
				if(result)
				{
					con.commit();
					this.result="Project Deleted SuccessFully";
				}
				else{
					con.rollback();
					this.result="Something Went Wrong1";
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//this.result="Something Went Wrong2";
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this.result;
		}
		
	}

}
