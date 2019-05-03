package com.nagarro.restbackApi.Models;

import java.util.Calendar;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Admin {
	
	@Id
	@Size(max = 20)	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String name;
	private String email;
	private String password;
	private String contact;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		if(id!=null)
			this.id = id;
			else
			{
				 this.id =generateAdminId();
			}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String generateAdminId() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        return "Admin_" + random.nextInt(100) + "_" + calendar.get(Calendar.YEAR);
    }
	

	

}
