package com.infy.story.contributor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.story.contributor.dto.ContributorDTO;
import com.infy.story.contributor.dto.LoginDTO;
import com.infy.story.contributor.dto.StoryDTO;
import com.infy.story.contributor.entity.Contributor;
import com.infy.story.contributor.entity.Story;
import com.infy.story.contributor.repository.ContributorRepository;
import com.infy.story.contributor.repository.StoryRepository;

@Service
@Transactional
public class contributorService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ContributorRepository contributorrepo;
    
    @Autowired
    StoryRepository storyrepo;

	public void savecontributor(ContributorDTO contributorDTO) {
        logger.info("Creation request for contributor {} with data {}",contributorDTO);
        Contributor contributor = contributorDTO.createContributor();
        contributorrepo.save(contributor);
    }
	public List<ContributorDTO> getAllcontributor() {

		List<Contributor> contributors = contributorrepo.findAll();
		List<ContributorDTO> contributorDTOs = new ArrayList<>();

		for (Contributor contributor : contributors) {
			ContributorDTO contributorDTO = ContributorDTO.valueOf(contributor);
			contributorDTOs.add(contributorDTO);
		}

		logger.info("Story Details : {}", contributorDTOs);
		return contributorDTOs;
	}
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for contributor {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		Contributor buy = contributorrepo.findByName(loginDTO.getname());
		if (buy != null && buy.getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		return false;
	}
	public void deletecontributor(String name) throws Exception {
		Optional<Contributor> contributor = contributorrepo.findById(name);
		contributor.orElseThrow(() -> new Exception("Service.contributor_NOT_FOUND"));
		contributorrepo.deleteById(name);
	}
	 public void createStory(StoryDTO storyDTO) {
	        logger.info("Creation request for story {} with data {}", storyDTO);
	       Story story = storyDTO.createEntity();
	       System.out.println("story"+ story);
	       storyrepo.saveall(story);
	    }
	 public void deleteStory(String name) {
			Optional<Story> contributor = storyrepo.findById(name);
			storyrepo.deleteById(name);
		}
	 
	 
	 public void createComment(StoryDTO storyDTO) {
	        logger.info("Creation request for comment {} with data {}", storyDTO);
	       Story story = storyDTO.createEntity();
	       System.out.println("story"+ story);
	       storyrepo.saveall(story);
	    }
	 public void deleteComment(String name) {
			Optional<Story> contributor = storyrepo.findById(name);
			storyrepo.deleteById(name);
		}
	
	public Contributor comments(Contributor contributor, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
	 
	/* public Story  topComments(Story story, String name) {
		 Contributor existingstory = contributorrepo.findById(name).orElse(null);
	        if((existingstory != null) && (((Contributor) existingstory).getComments() >= 1000)){
	            existingstory.setComments(story.getComments());
	            return storyrepo.saveAll(existingstory); 
	           
	        }
	        return null;
	   */
	 }
