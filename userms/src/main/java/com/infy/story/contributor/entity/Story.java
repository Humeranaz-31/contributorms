package com.infy.story.contributor.entity;


import javax.persistence.Column;



public class Story {

	
	
	String name;
	String datesubmitted;
	String storytitle;
	String comments;
    public String getStorytitle() {
		return storytitle;
	}
	public void setStorytitle(String storytitle) {
		this.storytitle = storytitle;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	@Column(name = "name",nullable = false)
	String name1;
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	
	public String getDatesubmitted() {
		return datesubmitted;
	}
	
	public void setDatesubmitted(String datesubmitted) {
	    this.datesubmitted = datesubmitted;
	}
	public int getComments(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
}


