package com.model;

public class EducationPojo {
	
	private int sn;
	private String year;
	private String title;
	private String subtitle;
	private String discription;
	private String datetime;
	
public EducationPojo() {
	// TODO Auto-generated constructor stub
}

public EducationPojo(int sn, String year, String title, String subtitle, String discription, String datetime) {
	super();
	this.sn = sn;
	this.year = year;
	this.title = title;
	this.subtitle = subtitle;
	this.discription = discription;
	this.datetime = datetime;
}

public int getSn() {
	return sn;
}

public void setSn(int sn) {
	this.sn = sn;
}

public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getSubtitle() {
	return subtitle;
}

public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
}

public String getDiscription() {
	return discription;
}

public void setDiscription(String discription) {
	this.discription = discription;
}

public String getDatetime() {
	return datetime;
}

public void setDatetime(String datetime) {
	this.datetime = datetime;
}

@Override
public String toString() {
	return "EducationPojo [sn=" + sn + ", year=" + year + ", title=" + title + ", subtitle=" + subtitle
			+ ", discription=" + discription + ", datetime=" + datetime + "]";
}

}
