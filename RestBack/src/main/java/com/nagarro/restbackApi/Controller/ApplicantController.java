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

import com.nagarro.restbackApi.Models.Activity;
import com.nagarro.restbackApi.Models.ApplicantActivityRecord;
import com.nagarro.restbackApi.Models.ApplicantDetails;
import com.nagarro.restbackApi.Service.ApplicantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicantController {
	
	@Autowired
	private ApplicantService applicantService;
	
	@CrossOrigin
	@RequestMapping(value = "/applicant-login",method  ={RequestMethod.POST},consumes = "application/json")
	public ApplicantDetails authenticate(@RequestBody ApplicantDetails user) {
		return applicantService.authenticate(user);
	}


	@RequestMapping(value = "/applicantList/{id}", method = { RequestMethod.GET })
	public ApplicantDetails getApplicantById(@PathVariable int id) {
		ApplicantDetails applicant= applicantService.getApplicantById(id);
		return applicant;
	}
	
	@RequestMapping(value = "/updateProfile/{id}",method  ={RequestMethod.PUT},consumes = "application/json")
	public void updateProfile(@RequestBody ApplicantDetails newapplicantDetails,@PathVariable int id) {
		applicantService.updateProfile(id,newapplicantDetails);
	}
	
	
	@RequestMapping(value = "/ApplicantActivities",method = {RequestMethod.GET})
	public List<Activity> applicantActivities(@RequestParam("level_id") String level_id,
											  @RequestParam("batch_id") String batch_id){
		return applicantService.getApplicantActivitiesByBatchAndByLevel(level_id,batch_id);
	}
	
	
	
	
	
	

}
