package com.nagarro.restbackApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restbackApi.Models.ApplicantActivityRecord;
import com.nagarro.restbackApi.Service.ApplicantActivityRecordService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicantActivityRecordController {
	
	@Autowired
	private ApplicantActivityRecordService applicantActivityrecordService;
	
	@RequestMapping(value = "/activitycheck")
	public String activityCheck(@RequestParam("activity_id") String activity_id,
			  							@RequestParam("applicant_id") int applicant_id) {	
		return applicantActivityrecordService.activityCheck(activity_id,applicant_id);
	}
	
	@RequestMapping(value = "/addApplicantActivity",method = {RequestMethod.POST},consumes = "application/json")
	public void addApplicantActivity(@RequestBody ApplicantActivityRecord applicantActivityRecord) {
		System.out.println(applicantActivityRecord);
		applicantActivityrecordService.addApplicantActivity(applicantActivityRecord);
		
	}
	
	@RequestMapping(value = "/getAllApplicantActivity",method = {RequestMethod.GET})
	public List<ApplicantActivityRecord> getAllApplicantActivity() {
		return applicantActivityrecordService.getAllApplicantActivity();
	}
	
	
	@RequestMapping(value = "/applicantHistory/{id}")
	public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(@PathVariable int id){
		return applicantActivityrecordService.getHistoryofActivitiesOfApplicant(id);
	}
	
	@RequestMapping(value = "/updateRecord/{id}" ,method = { RequestMethod.PUT }, consumes = "application/json")
	public void updateActivityRecord(@RequestBody ApplicantActivityRecord status,@PathVariable int id ) {
	
		applicantActivityrecordService.updateActivityRecord(status.getStatus().toString(),id);
		
	}
	
	@RequestMapping(value = "/updateActivityStatus/{id}" ,method = { RequestMethod.PUT }, consumes = "application/json")
	public void updateActivityStatus(@RequestBody ApplicantActivityRecord object,@PathVariable int id ) {
		//System.out.println("***************32143141");
		System.out.println("PErcentage score is "+object.getPercentageScore());
		applicantActivityrecordService.updateActivityStatus(object.getPercentageScore(),object.getStatus().toString(),id);
		//System.out.println("***************");
	}
	
	@RequestMapping(value = "/applicantScore/{id}")
	public double getApplicantScoreById(@PathVariable int id) {
		return applicantActivityrecordService.getApplicantScoreById(id);
	}
	
	
	
	
	
	
}
