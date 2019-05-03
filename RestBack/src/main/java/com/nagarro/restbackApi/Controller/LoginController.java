package com.nagarro.restbackApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restbackApi.Models.Admin;
import com.nagarro.restbackApi.Service.LoginService;

@RestController
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/admin-login",method  ={RequestMethod.POST},consumes = "application/json")
	public Admin authenticate(@RequestBody Admin user) {
		System.out.println("in login post");
		System.out.println(user .getEmail() +" "+user.getPassword());
		return loginService.authenticate(user);
	}
	
	
	
}
