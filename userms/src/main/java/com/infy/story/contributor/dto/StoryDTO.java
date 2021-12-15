package com.infy.story.contributor.dto;

import com.infy.story.contributor.entity.Story;

public class StoryDTO {

	String storytitle;
	String datesubmitted;
	String comments;
	String name;
	
	
	

	public String getstorytitle() {
		return storytitle;
	}

	public void setstorytitle(String storytitle) {
		this.storytitle = storytitle;
	}


	public String getdatesubmitted() {
		return datesubmitted;
	}

	public void setdatesubmitted(String datesubmitted) {
		this.datesubmitted = datesubmitted;
	}

	public String getcomments() {
		return comments;
	}

	public void setcomments(String comments) {
		this.comments = comments;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	

	public StoryDTO() {
		super();
	}
		
		

	// Converts Entity into DTO
	public static StoryDTO valueOf(Story product) {
		StoryDTO productDTO = new StoryDTO();
		
		productDTO.setstorytitle(product.getStorytitle());
		
		productDTO.setdatesubmitted(product.getDatesubmitted());
		productDTO.setcomments(product.getComments());
		productDTO.setname(product.getname());
		
		return productDTO;
	}
	@Override
	public String toString() {
		return "ContributorDTO [ storytitle=" + storytitle + ",  datesubmitted=" + datesubmitted + ", comments=" + comments + ", name=" + name + "]";
	}

	public Story createEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}


	


