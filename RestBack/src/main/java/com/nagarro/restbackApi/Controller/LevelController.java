package com.nagarro.restbackApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restbackApi.Models.Level;
import com.nagarro.restbackApi.Service.LevelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LevelController {

	@Autowired
	private LevelService levelservice;

	@RequestMapping(value = "/levels", method = { RequestMethod.GET })
	public List<Level> viewAllLevel() {
		List<Level> levels = levelservice.getAllLevels();
		return levels;
	}
	
	@RequestMapping(value = "/level/{id}", method = { RequestMethod.GET })
	public Level getLevelById(@PathVariable String id) {
		return levelservice.getLevelById(id);
	}

	@RequestMapping(value = "/addLevel", method = { RequestMethod.POST }, consumes = "application/json")
	public void addLevel(@RequestBody Level levelToAdd) {
		//System.out.println(levelToAdd);
		levelservice.addLevel(levelToAdd);
	}

	@RequestMapping(value = "/level/{id}", method = { RequestMethod.PUT }, consumes = "application/json")
	public void updateLevel(@RequestBody Level newLevel,@PathVariable String id) {
		//System.out.println("******");
		//System.out.println(newLevel.getLevelName() +  " , "+ newLevel.getLevelDesc() + " ," +newLevel.getQualifyPoints() );
		//System.out.println("******");
		levelservice.updateLevel(id,newLevel); 
	}
	
	@RequestMapping(value = "/level/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable String id) {
		levelservice.deleteLevel(id);
	}
}
