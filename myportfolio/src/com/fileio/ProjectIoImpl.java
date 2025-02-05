package com.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;

public class ProjectIoImpl implements projectIo {

	private InputStream inputStream;
	private FileOutputStream fileOutputStream;
	private String path;
	private boolean result;
	@SuppressWarnings("finally")
	@Override
	public boolean writeProject(Part part, String forfilename) {
		try {
			 inputStream = part.getInputStream();
			
			byte[] b=new byte[inputStream.available()];
			inputStream.read(b);
			
			
			path="C:\\Users\\DELL\\jdbc1\\myportfolio\\WebContent\\myproject\\"+forfilename;
			
			 fileOutputStream = new FileOutputStream(path);
			fileOutputStream.write(b);
			
			result=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
			
		finally
		{

			try {
				fileOutputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public boolean daleteProject(String forfilename) {
		try {
			 
			
			path="C:\\Users\\DELL\\jdbc1\\myportfolio\\WebContent\\myproject\\"+forfilename;
			
			new File(path).delete();
			result=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
			
		finally
		{

			try {
				fileOutputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}

}
