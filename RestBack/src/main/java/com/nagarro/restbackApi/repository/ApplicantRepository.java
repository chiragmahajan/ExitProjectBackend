package com.nagarro.restbackApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.restbackApi.Models.Activity;
import com.nagarro.restbackApi.Models.ApplicantDetails;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantDetails, Integer> {

	ApplicantDetails findByEmail(String email);

	@Query(value = "FROM Activity  WHERE batch_id =:batchId and level_id =:levelId")
	List<Activity> findByLevelIdAndBatch(@Param("levelId") String levelId,@Param("batchId") String batchId);

}
