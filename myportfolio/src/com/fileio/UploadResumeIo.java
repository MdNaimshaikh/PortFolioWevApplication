package com.fileio;

import javax.servlet.http.Part;

public interface UploadResumeIo {
	
	public boolean isExist();
	public String writeResume(Part part);
	public boolean deleteResume();

}
