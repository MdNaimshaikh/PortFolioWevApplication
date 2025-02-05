package com.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class UploadResumeIoImpl implements UploadResumeIo {

	private InputStream inputStream;
	private FileOutputStream fos;
	private boolean boolresult;
	private String result;
	@Override
	public boolean isExist() {
		
		try {
			String path="C:\\Users\\DELL\\jdbc1\\myportfolio\\WebContent\\myresume\\mycv.pdf";
			 File file=new File(path);
			 boolresult=file.exists();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boolresult;
	}
	@Override
	public String writeResume(Part part) {
		try {
			String path="C:\\Users\\DELL\\jdbc1\\myportfolio\\WebContent\\myresume\\mycv.pdf";
			
			 inputStream = part.getInputStream();
			byte b[]=new byte[inputStream.available()];
			inputStream.read(b);
			
		 fos = new FileOutputStream(path);
			fos.write(b);
			
			result="uploaded";
			
		} catch (Exception e) {
			result="Something went wrong";
			
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public boolean deleteResume() {
		try {
			String path="C:\\Users\\DELL\\jdbc1\\myportfolio\\WebContent\\myresume\\mycv.pdf";
			 File file=new File(path);
			 boolresult=file.delete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boolresult;
	}

}
