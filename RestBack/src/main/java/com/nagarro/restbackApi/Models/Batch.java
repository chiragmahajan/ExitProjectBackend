package com.nagarro.restbackApi.Models;

import java.util.Calendar;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Batch {

	@Id
	@Size(max=20)
	private String batchId;
	
	private String year;
	
	private String technology;
	
	private String batchDescription;
	
	
	private String startDate;
	
	
//	@OneToMany(mappedBy = "batch")
//	private List<Activity> activity;
//	
//	@OneToMany(mappedBy = "batch")
//	private List<ApplicantDetails> applicantDetails ;
	
	
	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		if(batchId!=null)
			this.batchId = batchId;
			else
			{
				this.batchId =generateBatchId();
			}
	}

	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getTechnology() {
		return technology;
	}


	public void setTechnology(String technology) {
		this.technology = technology;
	}


	public String getBatchDescription() {
		return batchDescription;
	}


	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String generateBatchId() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        return "Batch_" + random.nextInt(100) + "_" + calendar.get(Calendar.YEAR);
    }

}
