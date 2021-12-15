package com.infy.story.contributor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.story.contributor.entity.Contributor;
@Repository
public interface ContributorRepository extends JpaRepository<Contributor, String> {

	Contributor findByName(String Name);
	Contributor findByEmail(String Email);
}
