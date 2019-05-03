package com.nagarro.restbackApi.Models;

import java.util.Calendar;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(uniqueConstraints =@UniqueConstraint(columnNames={"levelNumber"}) )
public class Level {
	@Override
	public String toString() {
		return "Level [levelId=" + levelId + ", levelNumber=" + levelNumber + ", levelName=" + levelName
				+ ", levelDesc=" + levelDesc + ", qualifyPoints=" + qualifyPoints + "]";
	}

	@Id
	@Size(max = 20)
	private String levelId;
	private int levelNumber;
	private String levelName;
	private String levelDesc;
	private int qualifyPoints;

//	@OneToMany(mappedBy = "level")
//	private List<Activity> activity=new ArrayList<>();
//
//	@OneToMany(mappedBy = "level")
//	private List<ApplicantDetails> applicantDetails=new ArrayList<>();

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		if (levelId != null)
			this.levelId = levelId;
		else {
			this.levelId = generateLevelId();
		}
	}

	public String generateLevelId() {
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();
		return "Level_" + random.nextInt(100) + "_" + calendar.get(Calendar.YEAR);
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public int getQualifyPoints() {
		return qualifyPoints;
	}

	public void setQualifyPoints(int qualifyPoints) {
		this.qualifyPoints = qualifyPoints;
	}

//	public List<Activity> getActivity() {
//		return activity;
//	}
//
//	public void setActivity(List<Activity> activity) {
//		this.activity = activity;
//	}
//
//	public List<ApplicantDetails> getApplicantDetails() {
//		return applicantDetails;
//	}
//
//	public void setApplicantDetails(List<ApplicantDetails> applicantDetails) {
//		this.applicantDetails = applicantDetails;
//	}


}
