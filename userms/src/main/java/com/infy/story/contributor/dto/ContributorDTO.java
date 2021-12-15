package com.infy.story.contributor.dto;



import com.infy.story.contributor.entity.Contributor;


public class ContributorDTO {
    
	
	
	String name;
	String email;
	String password;



	

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


		@Override
	public String toString() {
		return "contributorDTO [ name=" + name + ", email=" + email + ", password=" + password + "]";
	}

		// Converts Entity into DTO
		public static ContributorDTO valueOf(Contributor contributor) {
			ContributorDTO contributorDTO = new ContributorDTO();
			
			contributorDTO.setName(contributor.getName());
			contributorDTO.setEmail(contributor.getEmail());
		
			contributorDTO.setPassword(contributor.getPassword());
			
			return contributorDTO;
		}
		public Contributor createContributor() {
            Contributor contributor = new Contributor();
           
            contributor.setName(this.getName());
             contributor.setEmail(this.getEmail());
            contributor.setPassword(this.getPassword());
           
            return contributor;
        }

}
