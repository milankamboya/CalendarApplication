package com.global.model;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.Date;

public class EventMaster implements Serializable {
	private static final long serialVersionUID = -7506535457442016815L;

	private String eventId;
	private String eventTitle;
	private Clob description;
	private Date startDate;
	private Timestamp startTime;
	private Date endDate;
	private Timestamp endTime;
	private String repeats;
	private Clob shared;
	private UserMaster user;
	
	public EventMaster(){
		
	}
	
	public EventMaster(String eventId, String eventTitle, Clob description, 
			Date startDate, Timestamp startTime, Date endDate, Timestamp endTime, 
			String repeats, Clob shared, UserMaster user) {
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.description = description;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.repeats = repeats;
		this.shared = shared;
		this.user = user;
	}
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public Clob getDescription() {
		return description;
	}
	public void setDescription(Clob description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getRepeats() {
		return repeats;
	}
	public void setRepeats(String repeats) {
		this.repeats = repeats;
	}
	public Clob getShared() {
		return shared;
	}
	public void setShared(Clob shared) {
		this.shared = shared;
	}
	public UserMaster getUser() {
		return user;
	}
	public void setUser(UserMaster user) {
		this.user = user;
	}
	
}