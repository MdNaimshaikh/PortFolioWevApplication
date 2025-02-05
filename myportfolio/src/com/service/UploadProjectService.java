package com.service;

import javax.servlet.http.Part;

public interface UploadProjectService {
	
	public String uploadProjectService1(Part part);
	public String uploadProjectService2(Part part, String datetime);
	public String deleteProjectService(String sn, String forfilename);
	

}
