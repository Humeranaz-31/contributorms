package com.infy.story.contributor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.story.contributor.dto.ContributorDTO;
import com.infy.story.contributor.dto.LoginDTO;
import com.infy.story.contributor.dto.StoryDTO;
import com.infy.story.contributor.entity.Contributor;
import com.infy.story.contributor.service.contributorService;


@RestController
@CrossOrigin

public class ContributorController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    Environment environment;
	
	@Value("${product.uri}")
	String product;
  
	@Autowired
	RestTemplate restTemplate;
    @Autowired
    contributorService contributorservice;
   
    @PostMapping(value = "/api/contributor/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createContributor(@RequestBody ContributorDTO contributorDTO) {
        logger.info("Creation request for contributor {} with data {}", contributorDTO);
        contributorservice.savecontributor(contributorDTO);
    }
	@GetMapping(value = "/api/contributors", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ContributorDTO> getAllContributors() {
		logger.info("Fetching all contributors");
		return contributorservice.getAllcontributor();
	}

	@PostMapping(value = "/buyer/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for user {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		return contributorservice.login(loginDTO);
	}
	
	
		@DeleteMapping(value = "/contributor/{name}")
		public ResponseEntity<String> deleteBuyer(@PathVariable String name) throws Exception {
			contributorservice.deletecontributor(name);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
		
		@PostMapping(value = "/api/story/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void saveWishlist( @RequestBody StoryDTO storyDTO) {
	        logger.info("Creation request for customer {} with data {}", storyDTO);
	        Map<String,Object> map = new HashMap<String,Object>();
	       // map.put("prodid",storyDTO.getname());
	        map.put("name",storyDTO.getname());
	        System.out.println("adding map"+ map);
	        StoryDTO obj = restTemplate.getForObject("http://localhost:8200/api/contributor/{name}", StoryDTO.class,map );
	        System.out.println("adding wishlist"+ obj);
	        contributorservice.createStory(storyDTO);
		}
		@DeleteMapping(value = "/story/{name}")
		public String deleteStory(@PathVariable String name) {
				contributorservice.deleteStory(name);
			    return "success";
			
		}
		@PostMapping(value = "/api/comments/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void saveCart( @RequestBody StoryDTO storyDTO) {
	        logger.info("Creation request for customer {} with data {}", storyDTO);
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("name",storyDTO.getname());
	        System.out.println("adding map"+ map);
	        StoryDTO cart = restTemplate.getForObject("http://localhost:8200/api/contributor/{name}", StoryDTO.class,map );
	       System.out.println("adding cart"+ cart);
	       contributorservice.createStory(storyDTO);
		}
		@DeleteMapping(value = "/comment/{name}")
		public String deleteCart(@PathVariable String name) {
			contributorservice.deleteComment(name);
			    return "success";
		}
		@RequestMapping(value = "/api/topcomments/{name}", method = RequestMethod.PUT)
	    public Contributor topcomments(@RequestBody Contributor contributor, @PathVariable String name) {
	        return contributorservice.comments(contributor, name);
	    }

}
 

