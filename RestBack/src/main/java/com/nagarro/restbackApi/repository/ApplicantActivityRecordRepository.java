package com.nagarro.restbackApi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.restbackApi.Models.ApplicantActivityRecord;

@Repository
public interface ApplicantActivityRecordRepository extends JpaRepository<ApplicantActivityRecord, Integer> {

	@Query(value = "Select * FROM applicant_activity_record  WHERE applicant_id =:applicant_id and activity_id=:activity_id", nativeQuery = true)
	public List<ApplicantActivityRecord> checkActivity(@RequestParam("activity_id") String activity_id,
			@RequestParam("applicant_id") int applicant_id);

	@Query(value = "Select * FROM applicant_activity_record  WHERE applicant_id =:id",nativeQuery = true)
	public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(@RequestParam("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "update  applicant_activity_record set status=:status WHERE record_id =:recordid ",nativeQuery = true)
     public void updateActivityRecord(@RequestParam("status") String status,@RequestParam("recordid") int recordid);
	
	@Modifying
	@Transactional
	@Query(value = "update  applicant_activity_record set status=:status , percentage_score=:percentage_score, points_earned=:points_earned where  record_id =:record_id ",nativeQuery = true)
	public void updateActivityStatus(@RequestParam("percentage_score") double percentage_score, @RequestParam("points_earned") double points_earned,
										@RequestParam("status") String status,@RequestParam("record_id") int record_id);
	
	@Query(value = "SELECT sum(points_earned) FROM applicant_activity_record where applicant_id =:applicant_id",nativeQuery = true)
	public double getTotalScore(@RequestParam("applicant_id") int applicant_id);
	
}
