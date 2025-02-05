package com.fileio;

import javax.servlet.http.Part;

public interface projectIo {
	public boolean writeProject(Part part, String forfilename);
	public boolean daleteProject( String forfilename);

}
