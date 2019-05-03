package com.nagarro.restbackApi.Controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restbackApi.Models.ApplicantDetails;
import com.nagarro.restbackApi.Service.ApplicantListService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicantListController {

	@Autowired
	private ApplicantListService applicantListService;
	
	@RequestMapping(value = "/applicantList", method = { RequestMethod.GET })
	public List<ApplicantDetails> viewAllApplicants() {
		List<ApplicantDetails> applicants = applicantListService.getAllapplicants();
		return applicants;
	}
	
	
	@RequestMapping(value = "/addApplicant", method = { RequestMethod.POST }, consumes = "application/json")
	public void addApplicant(@RequestBody ApplicantDetails applicantToAdd) {
		applicantListService.addApplicant(applicantToAdd);
		EmailController controller=new EmailController();
		try {
			controller.sendEmail(applicantToAdd);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
