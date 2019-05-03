package com.nagarro.restbackApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.restbackApi.Models.Admin;

public interface LoginRepository extends JpaRepository<Admin, String>{
	
	Admin findByEmail(String email);
}
