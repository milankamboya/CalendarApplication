package com.global.model;

import java.io.Serializable;
import java.sql.Clob;

public class UserMaster implements Serializable {
	private static final long serialVersionUID = -324595582109215711L;

	private String userId;
	private String firstName;
	private String lastName;
	private String gender;
	private String phone;
	private String dateOfbirth;
	private Clob address;
	private String userLanguage;
	private String timeZone;
	
	public UserMaster(){
		
	}

	public UserMaster(String userId, String firstName, String lastName, 
			String gender, String phone, String dateOfbirth,
			Clob address, String userLanguage, String timeZone) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
		this.dateOfbirth = dateOfbirth;
		this.address = address;
		this.userLanguage = userLanguage;
		this.timeZone = timeZone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public Clob getAddress() {
		return address;
	}

	public void setAddress(Clob address) {
		this.address = address;
	}

	public String getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(String userLanguage) {
		this.userLanguage = userLanguage;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

}
