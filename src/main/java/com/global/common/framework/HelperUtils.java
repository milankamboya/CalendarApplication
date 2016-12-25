package com.global.common.framework;

public interface HelperUtils 
{
	/**
	 * 
	 * @param email
	 * @param body
	 */
	public void sendEmailcofirmation(String email, String body);
	
	/**
	 * 
	 * @return
	 */
	public String generateSequenceId();   
}
