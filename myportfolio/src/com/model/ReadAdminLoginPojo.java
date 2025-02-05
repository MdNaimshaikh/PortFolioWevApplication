package com.model;

public class ReadAdminLoginPojo {
	private int sn;
	private String username;
	private String password;
	public ReadAdminLoginPojo(int sn, String username, String password) {
		super();
		this.sn = sn;
		this.username = username;
		this.password = password;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
