package com.model;

public class UploadProjectPojo {
	
	private int sn;
	
	private String forfilename;
	
	private String datetime;

	public UploadProjectPojo() {
		// TODO Auto-generated constructor stub
	}

	public UploadProjectPojo(int sn, String forfilename, String datetime) {
		super();
		this.sn = sn;
		this.forfilename = forfilename;
		this.datetime = datetime;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getForfilename() {
		return forfilename;
	}

	public void setForfilename(String forfilename) {
		this.forfilename = forfilename;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
}
