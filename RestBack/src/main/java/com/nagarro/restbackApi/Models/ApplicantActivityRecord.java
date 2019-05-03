package com.nagarro.restbackApi.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nagarro.restbackApi.Enums.Status;


@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"applicantId"}))
public class ApplicantActivityRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	
	@Override
	public String toString() {
		return "ApplicantActivityRecord [status=" + status + ", percentageScore=" + percentageScore + ", pointsEarned="
				+ pointsEarned + ", Description=" + Description + ", Document=" + Document + ", startDate=" + startDate
				+ ", doneDate=" + doneDate + ", completionDate=" + completionDate + ", applicantDetails="
				+ applicantDetails + ", level=" + level + ", activity=" + activity + "]";
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status status;
	
	private double percentageScore;
	
	private double pointsEarned;
	
	
	private String Description;

	private String Document;
	
	private String startDate;
	
	private String doneDate;
	
	private String completionDate;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="applicantId")
	private ApplicantDetails applicantDetails;
	
	
	//optional 
	@ManyToOne(cascade =  CascadeType.PERSIST)
	@JoinColumn(name="levelId")
	private Level level;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="activityId")
	private Activity activity;
	
	private int count;

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getPercentageScore() {
		return percentageScore;
	}

	public void setPercentageScore(double percentageScore) {
		this.percentageScore = percentageScore;
	}

	public double getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(double pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDocument() {
		return Document;
	}

	public void setDocument(String document) {
		Document = document;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public ApplicantDetails getApplicantDetails() {
		return applicantDetails;
	}

	public void setApplicantDetails(ApplicantDetails applicantDetails) {
		this.applicantDetails = applicantDetails;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}


	

}
