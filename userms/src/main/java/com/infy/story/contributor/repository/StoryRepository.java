package com.infy.story.contributor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.story.contributor.entity.Contributor;
import com.infy.story.contributor.entity.Story;
@Repository
public interface StoryRepository extends JpaRepository<Story, String> {

	
	Story findByName(String Name);
	Optional<Story> findById(String Name);

	void saveall(Story story);
	Story saveAll(Contributor existingstory);
	void saveAll(Story story);
  //  void  save(Story story);
	
	

	
    
}
