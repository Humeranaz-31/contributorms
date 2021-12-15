package com.infy.story.contributor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints= 
           @UniqueConstraint(columnNames={"name", "email"}))

public class Contributor {

	@Id
	
	@Column(nullable = false)
	String name;
	@Column(nullable = false)
	String email;
	
	@Column(nullable = false)
	String password;
	

	
	public Contributor() {
		super();
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	public Contributor( String name, String email, String password) {
		super();
	
		this.name = name;
		this.email = email;
	
		this.password = password;

	}

	@Override
	public String toString() {
		return "Buyer [ name=" + name + ", email=" + email + ",  password=" + password+ "]";
	}

	public void setcontributorname(String getcontributorname) {
		// TODO Auto-generated method stub
		
	}

	public int getComments() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void setComments(String comments) {
		// TODO Auto-generated method stub
		
	}
	
}
