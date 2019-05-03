package com.nagarro.restbackApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Models.Admin;
import com.nagarro.restbackApi.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired 
	private  LoginRepository loginInterface;
	
	/**
	 * @param user
	 * @return  check admin credentials
	 */
	public Admin authenticate(Admin user) {
		 Admin userob=loginInterface.findByEmail(user.getEmail());
		 if(userob == null) {
			 return null;
		 }
		 if(userob.getPassword().equals(user.getPassword())) {
			 return userob;
		 }
		 else {
			 return null;
		 }
	}

	
}
