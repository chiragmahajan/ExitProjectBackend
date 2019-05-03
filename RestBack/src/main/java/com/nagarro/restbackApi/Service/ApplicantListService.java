package com.nagarro.restbackApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Models.ApplicantDetails;
import com.nagarro.restbackApi.repository.ApplicantListRepository;

@Service
public class ApplicantListService {
	
	@Autowired
	private ApplicantListRepository applicantListRepository;
	
	/**
	 * @return  get all applicants
	 */
	public List<ApplicantDetails> getAllapplicants() {
		// TODO Auto-generated method stub
		return applicantListRepository.findAll();
	}

	

	/**
	 * @param applicant  adding an applicant 
	 */
	public void addApplicant(ApplicantDetails applicant) {
		// TODO Auto-generated method stub
		List<ApplicantDetails> list=getAllapplicants();
		System.out.println("size is "+list.size());
		applicant.setApplicantId(list.size()+1);
		System.out.println("set applicant id is "+applicant.getApplicantId());
		applicantListRepository.save(applicant);
		
		
	}
	
	
	

}
