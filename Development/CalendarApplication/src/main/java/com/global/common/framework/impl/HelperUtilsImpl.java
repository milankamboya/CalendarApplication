package com.global.common.framework.impl;

import static com.global.common.framework.impl.GlobalConstants.GLOBAL_PREFIX;
import static com.global.common.framework.impl.GlobalConstants.UNDERSCORE;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.common.framework.HelperUtils;
@Service
@Transactional
public class HelperUtilsImpl implements HelperUtils 
{
	/*
	 * (non-Javadoc)
	 * @see com.global.common.framework.HelperUtils#sendEmailcofirmation(java.lang.String, java.lang.String)
	 */
	public void sendEmailcofirmation(String email, String body) 
	{
	  String host = "smtp.gmail.com";
	  String port = "587";
	  final String username = "kamboyamilan@gmail.com";
	  final String password = "AlfresCo.123Milan";
	  String to = email;
	  Properties props = System.getProperties();
	  props.setProperty("mail.smtp.host", host);
	  props.setProperty("mail.smtp.port", port);
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.debug", "true");
	  props.put("mail.store.protocol", "pop3");
	  props.put("mail.transport.protocol", "smtp");		
	  props.put("mail.smtp.starttls.enable", "true");

	  try{
	    Session session = Session.getDefaultInstance(props, new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
					  return new PasswordAuthentication(username, password);
				}});

	    // -- Create a new message --
	    Message msg = new MimeMessage(session);
	    msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	    msg.addHeader("format", "flowed");
	    msg.addHeader("Content-Transfer-Encoding", "8bit");
		// -- Set the FROM and TO fields --
	    msg.setFrom(new InternetAddress(username));
	    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
	    msg.setSubject("Confirmation Mail from Calendar App for SignUp!");
	    //msg.setText("How are you");
	    msg.setSentDate(new Date());
	    
	    // Create the message body part with attachments
	    BodyPart messageBodyPart = new MimeBodyPart();
	    // Fill the message
	    messageBodyPart.setContent(body, "text/html; charset=utf-8");
	    // Create a multipart message for attachment
	    Multipart multipart = new MimeMultipart();
	    // Set text message part
	    multipart.addBodyPart(messageBodyPart);
	    // Send the complete message parts
	    msg.setContent(multipart);
	    Transport.send(msg);
	    System.out.println("Message sent.");
	  }catch (MessagingException e){ 
	    System.out.println("Error : " + e);
	  }
	}

	/*
	 * (non-Javadoc)
	 * @see com.global.common.framework.HelperUtils#generateSequenceId()
	 */
	public String generateSequenceId() 
	{
		return GLOBAL_PREFIX + UNDERSCORE + RandomStringUtils.randomAlphanumeric(18).toUpperCase();
	}
	
}
