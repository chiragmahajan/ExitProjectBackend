package com.nagarro.restbackApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Models.Activity;
import com.nagarro.restbackApi.Models.ApplicantDetails;
import com.nagarro.restbackApi.repository.ApplicantRepository;

@Service
public class ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepository;

	/**
	 * @param user
	 * @return  checks the credentials of applicant
	 */
	public ApplicantDetails authenticate(ApplicantDetails user) {
		ApplicantDetails userob=applicantRepository.findByEmail(user.getEmail());
		 if(userob == null) {
			 return null;
		 }
		 if(userob.getPassword().equals(user.getPassword())) {
			 return userob;
		 }
		 else {
			 return null;
		 }
	}

	/**
	 * @param id
	 * @return  find applicant by Id
	 */
	public ApplicantDetails getApplicantById(int id) {
		// TODO Auto-generated method stub
		return applicantRepository.findById(id).get();
	}

	/**
	 * @param id
	 * @param newapplicantDetails   update the applicant
	 */
	public void updateProfile(int id, ApplicantDetails newapplicantDetails) {
		// TODO Auto-generated method stub
		ApplicantDetails old=applicantRepository.getOne(id);
		if(old!=null)
		{
		    newapplicantDetails.setApplicantId(old.getApplicantId());
            newapplicantDetails.setBatch(old.getBatch());
            newapplicantDetails.setLevel(old.getLevel());
            newapplicantDetails.setNagpStatus(old.getNagpStatus());
			if(newapplicantDetails.getContactNumber()==0) {
				newapplicantDetails.setContactNumber(old.getContactNumber());
			}
			if(newapplicantDetails.getEmail().equals("")) {
				newapplicantDetails.setEmail(old.getEmail());
			}
			if(newapplicantDetails.getPassword().equals("")) {
				newapplicantDetails.setPassword(old.getPassword());
			}
			if(newapplicantDetails.getName().equals("")) {
				newapplicantDetails.setName(old.getName());
			}
			applicantRepository.save(newapplicantDetails);
		}
		else
		{
			System.out.println("error");
		}
		
	}

	/**
	 * @param level_id
	 * @param batch_id
	 * @return   get applicant_activities by level and batch
	 */
	public List<Activity> getApplicantActivitiesByBatchAndByLevel(String level_id, String batch_id) {
		// TODO Auto-generated method stub
		System.out.println(level_id + " of "+ batch_id);
		return applicantRepository.findByLevelIdAndBatch(level_id,batch_id);
	}

	
	
	
	
	
}
