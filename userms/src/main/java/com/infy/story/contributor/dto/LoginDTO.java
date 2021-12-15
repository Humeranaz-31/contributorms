package com.infy.story.contributor.dto;

public class LoginDTO {

	String email;
	String password;
	String name;
	
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
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	public String getname() {
		// TODO Auto-generated method stub
		return name;
	
	}
	public void setname(String name)  {
		this.name = name;
	}
	
}
