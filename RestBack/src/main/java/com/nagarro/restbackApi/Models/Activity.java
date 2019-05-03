package com.nagarro.restbackApi.Models;

import java.util.Calendar;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;


@Entity
@Table(uniqueConstraints =@UniqueConstraint(columnNames={"levelId","batchId","name"}) )
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Activity {
	
	@Id
	@Size(max=20)
	private String activityId;
	
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", batch=" + batch + ", level=" + level + ", name=" + name
				+ ", description=" + description + ", maxAttempts=" + maxAttempts + ", qualifyPoints=" + qualifyPoints
				+ ", getActivityId()=" + getActivityId() + ", getBatch()=" + getBatch() + ", getLevel()=" + getLevel()
				+ ", getName()=" + getName() + ", getDescription()=" + getDescription() + ", getMaxAttempts()="
				+ getMaxAttempts() + ", getQualifyPoints()=" + getQualifyPoints() + ", generateActivityId()="
				+ generateActivityId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "batchId")
	private Batch batch;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "levelId")
	private Level level;
	
	
	private String name;
	
	private String description;
	
	private int maxAttempts;
	
	private int qualifyPoints;
	
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		if(activityId!=null)
			this.activityId = activityId;
			else
			{
				this.activityId =generateActivityId();
			}
	}
	
	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
//	public List<ApplicantActivityRecord> getApplicantActivityRecords() {
//		return applicantActivityRecords;
//	}
//
//	public void setApplicantActivityRecords(List<ApplicantActivityRecord> applicantActivityRecords) {
//		this.applicantActivityRecords = applicantActivityRecords;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	public int getQualifyPoints() {
		return qualifyPoints;
	}

	public void setQualifyPoints(int qualifyPoints) {
		this.qualifyPoints = qualifyPoints;
	}

	

	public String generateActivityId() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        return "Activity_" + random.nextInt(100) + "_" + calendar.get(Calendar.YEAR);
    }


	
}
