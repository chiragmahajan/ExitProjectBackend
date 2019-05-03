package com.nagarro.restbackApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restbackApi.Models.Batch;
import com.nagarro.restbackApi.Service.BatchService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BatchController {
	
	@Autowired
	private BatchService batchService;

	@RequestMapping(value = "/batches", method = { RequestMethod.GET })
	public List<Batch> viewAllBatches() {
		List<Batch> Batches = batchService.getAllBatches();
		return Batches;
	}
	
	@RequestMapping(value = "/batch/{id}", method = { RequestMethod.GET })
	public Batch getBatchById(@PathVariable String id) {
		return batchService.getBatchById(id);
	}

	@RequestMapping(value = "/addBatch", method = { RequestMethod.POST }, consumes = "application/json")
	public void addBatch(@RequestBody Batch batchToAdd) {
		System.out.println(batchToAdd);
		batchService.addBatch(batchToAdd);
	}

	@RequestMapping(value = "/batch/{id}", method = { RequestMethod.PUT }, consumes = "application/json")
	public void updateBatch(@RequestBody Batch newBatch,@PathVariable String id) {
		System.out.println("In update of batch called ");
		batchService.updateBatch(id,newBatch); 
	}
	
	@RequestMapping(value = "/batch/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable String id) {
		batchService.deleteBatch(id);
	}
	
	
}
