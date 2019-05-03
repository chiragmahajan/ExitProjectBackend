package com.nagarro.restbackApi.Service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Enums.Status;
import com.nagarro.restbackApi.Models.ApplicantActivityRecord;
import com.nagarro.restbackApi.repository.ApplicantActivityRecordRepository;

@Service
public class ApplicantActivityRecordService {
	
	Logger logger=Logger.getLogger(ApplicantActivityRecordService.class.getName());
	

	@Autowired
	private ApplicantActivityRecordRepository applicantActivityRecordRepository;
	
	/**
	 * @param applicantActivityRecord add an activity
	 */
	public void addApplicantActivity(ApplicantActivityRecord applicantActivityRecord) {
		// TODO Auto-generated method stub
		if(applicantActivityRecord.getRecordId() == 0)
		{
			List<ApplicantActivityRecord> list=applicantActivityRecordRepository.findAll();
			int size=list.size();
			applicantActivityRecord.setRecordId(size+1);
			applicantActivityRecordRepository.save(applicantActivityRecord);
		}		
	}

	/**
	 * @return list of all activities
	 */
	public List<ApplicantActivityRecord> getAllApplicantActivity() {
		// TODO Auto-generated method stub
		return applicantActivityRecordRepository.findAll();
	}

	/**
	 * @param activity_id
	 * @param applicant_id
	 * @return check whether record is present in db and return the string depending upon remaining chances
	 */
	public String activityCheck(String activity_id, int applicant_id) {
		// TODO Auto-generated method stub
		List<ApplicantActivityRecord> fetchallRecords=applicantActivityRecordRepository.checkActivity(activity_id, applicant_id);
		System.out.println(fetchallRecords);
//		System.out.println("current status is "+fetchallRecords.get(0).getStatus());
//		System.out.println("max attempts is "+fetchallRecords.get(0).getActivity().getMaxAttempts());
//		System.out.println("curent count is "+fetchallRecords.get(0).getCount());
//		
		if(fetchallRecords.size()==0) {
			logger.info("no record found");
			
			return "true";
		}
		else {
			System.out.println("in else");
			//check if status is complete,we have to disable button
			if(fetchallRecords.get(0).getStatus().toString().equals("COMPLETED")) {
				logger.info("status is completed");
				return "COMPLETED";
			}
			else if(fetchallRecords.get(0).getStatus().toString().equals("REVIEW_FAILED")) {
				System.out.println("review match failed hit ");
				logger.info("status is failed");
				logger.info("count is ="+fetchallRecords.get(0).getCount());
				int count=fetchallRecords.get(0).getCount();
				logger.info("max attempt is "+fetchallRecords.get(0).getActivity().getMaxAttempts());
				int maxAttempts=fetchallRecords.get(0).getActivity().getMaxAttempts();
				if(count<maxAttempts) {
					//we can reAttempt the activity
					System.out.println("about to update the count");
					System.out.println("record id is "+fetchallRecords.get(0).getRecordId());
					NextAttemptForActivity(fetchallRecords.get(0));
					return "ADDMORE";
				}
				
				else {
					return "false";
				}
			}
			else {
				return "PENDING";
			}
			
			
		}
	}
	
	private void NextAttemptForActivity(ApplicantActivityRecord applicantActivityRecord) {
		// TODO Auto-generated method stub
		logger.info("information==>"+applicantActivityRecord);
		logger.info("new count is="+applicantActivityRecord.getCount()+1);
		
		applicantActivityRecord.setCount(applicantActivityRecord.getCount()+1);
		applicantActivityRecord.setStatus(Status.PLANNED);
		
		applicantActivityRecordRepository.save(applicantActivityRecord);		
	}

	/**
	 * @param id
	 * @return  list of activities by applicant_id
	 */
	public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(int id) {
		// TODO Auto-generated method stub
		return applicantActivityRecordRepository.getHistoryofActivitiesOfApplicant(id);
	}

	/**
	 * @param status
	 * @param recordid  update the status from Done to review_pending
	 */
	public void updateActivityRecord(String status, int recordid) {
		// TODO Auto-generated method stub
		ApplicantActivityRecord fetched=applicantActivityRecordRepository.findById(recordid).get();
		if(status.equals("DONE")){
			status="REVIEW_PENDING";
			applicantActivityRecordRepository.updateActivityRecord(status,recordid);
		}
		System.out.println(fetched);
		applicantActivityRecordRepository.updateActivityRecord(status,recordid);
	}

	/**
	 * @param percentage_score
	 * @param status
	 * @param record_id    change the status and %age of activity of applicant
	 */
	public void updateActivityStatus(double percentage_score, String status, int record_id) {
		ApplicantActivityRecord fetched=applicantActivityRecordRepository.findById(record_id).get();
		double points_earned = 0;
		if(status.equals("COMPLETED")) {
			points_earned = (fetched.getActivity().getQualifyPoints()*percentage_score)/100;
		}
		applicantActivityRecordRepository.updateActivityStatus(percentage_score,points_earned,status, record_id);
		
	}

		/**
		 * @param applicant_id
		 * @return  get total score of applicant
		 */
		public double getApplicantScoreById(int applicant_id) {
			if(applicantActivityRecordRepository.getHistoryofActivitiesOfApplicant(applicant_id).size()==0) {
				return 0;
			}
		return applicantActivityRecordRepository.getTotalScore(applicant_id);
	}

	

}
