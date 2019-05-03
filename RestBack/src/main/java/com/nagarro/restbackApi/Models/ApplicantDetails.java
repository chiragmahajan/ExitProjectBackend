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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.nagarro.restbackApi.Enums.NAGPStatus;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "Email")})
public class ApplicantDetails {

	@Override
	public String toString() {
		return "ApplicantDetails [applicantId=" + applicantId + ", Name=" + name + ", Email=" + email
				+ ", ContactNumber=" + contactNumber + ", batch=" + batch + ", level=" + level + ", nagpStatus="
				+ nagpStatus + ", password=" + password + "]";
	}

	@Id
	private int applicantId;
	
	private String name;
	
	private String email;
	
	private long contactNumber;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="batchId")
	private Batch batch;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="levelId")
	private Level level;
	
//	@OneToMany(mappedBy = "applicantDetails")
//	List<ApplicantActivityRecord> records;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private NAGPStatus nagpStatus;
	
	private String password;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
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

//	public List<ApplicantActivityRecord> getRecords() {
//		return records;
//	}
//
//	public void setRecords(List<ApplicantActivityRecord> records) {
//		this.records = records;
//	}

	public NAGPStatus getNagpStatus() {
		return nagpStatus;
	}

	public void setNagpStatus(NAGPStatus nagpStatus) {
		this.nagpStatus = nagpStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}
