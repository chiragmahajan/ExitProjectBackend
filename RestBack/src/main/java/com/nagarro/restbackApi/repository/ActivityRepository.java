package com.nagarro.restbackApi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.restbackApi.Models.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {

	@Modifying
	@Transactional
	@Query( " UPDATE Activity set name=:name, description=:description, "
			+ "maxAttempts=:maxAttempts , qualifyPoints=:qualifyPoints")
	public void update(@Param("name") String name,@Param("description") String description,@Param("qualifyPoints") int qualifyPoints,
							@Param("maxAttempts") int maxAttempts); 
	

}
