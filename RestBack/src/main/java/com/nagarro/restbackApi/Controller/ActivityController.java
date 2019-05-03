package com.nagarro.restbackApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restbackApi.Models.Activity;
import com.nagarro.restbackApi.Service.ActivityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/allActivities", method = { RequestMethod.GET })
	public List<Activity> viewAllActivities() {
		List<Activity> Activities = activityService.getAllActivities();
		return Activities;
	}
	
	@RequestMapping(value = "/activity/{id}", method = { RequestMethod.GET })
	public Activity getActivityById(@PathVariable String id) {
		return activityService.getActivityById(id);
	}

	@RequestMapping(value = "/addActivity", method = { RequestMethod.POST }, consumes = "application/json")
	public void addActivity(@RequestBody Activity activityToAdd) {
		System.out.println(activityToAdd);
		activityService.addActivity(activityToAdd);
	}

	@RequestMapping(value = "/activity/{id}", method = { RequestMethod.PUT }, consumes = "application/json")
	public void updateActivity(@RequestBody Activity newActivity,@PathVariable String id) {
		System.out.println("In update of Activity called ");
		activityService.updateActivity(id,newActivity); 
	}
	
	@RequestMapping(value = "/activity/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable String id) {
		activityService.deleteActivity(id);
	}
}
