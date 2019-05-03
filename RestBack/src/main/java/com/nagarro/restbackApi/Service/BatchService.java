package com.nagarro.restbackApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Models.Batch;
import com.nagarro.restbackApi.repository.BatchRepository;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	
	/**
	 * @return  list of all batches
	 */
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return batchRepository.findAll();
	}

	/**
	 * @param batch  add a new batch
	 */
	public void addBatch(Batch batch) {
		// TODO Auto-generated method stub
		if (batch.getBatchId().equals("") || batch.getBatchId()== null) {
			batch.setBatchId(batch.generateBatchId());
		}
		batchRepository.save(batch);
		
	}

	/**
	 * @param id
	 * @param newBatch  update batch details
	 */
	public void updateBatch(String id, Batch newBatch) {
		// TODO Auto-generated method stub
		System.out.println("in update batch");
		Batch old=batchRepository.getOne(id);
		if(old!=null) 
		{
			newBatch.setBatchId(old.getBatchId());
			newBatch.setStartDate(old.getStartDate());
			if(newBatch.getBatchDescription().equals("")) {
				newBatch.setBatchDescription(old.getBatchDescription());
			}
			if(newBatch.getTechnology().equals("")) {
				newBatch.setTechnology(old.getTechnology());
			}
			if(newBatch.getYear().equals("")) {
				newBatch.setYear(old.getYear());
			}
			batchRepository.save(newBatch);
		}
		else {
			System.out.println("Error ");
		}
		
	}

	public void deleteBatch(String id) {
		// TODO Auto-generated method stub
		Batch old=batchRepository.getOne(id);
		System.out.println();
		batchRepository.delete(old);
	}

	public Batch getBatchById(String id) {
		// TODO Auto-generated method stub
		return batchRepository.findById(id).get();
	}
	
	
}
