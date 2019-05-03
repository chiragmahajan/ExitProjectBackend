package com.nagarro.restbackApi.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private String attachment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="recordId")
	private ApplicantActivityRecord applicantActivityRecord;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public ApplicantActivityRecord getApplicantActivityRecord() {
		return applicantActivityRecord;
	}

	public void setApplicantActivityRecord(ApplicantActivityRecord applicantActivityRecord) {
		this.applicantActivityRecord = applicantActivityRecord;
	}
	
}
