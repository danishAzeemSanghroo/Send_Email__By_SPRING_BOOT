package com.email.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

@Service
public class EmailService {
	
	String from = "yourEmail";
	
	public boolean emailSend(String subject, String message,String to) {
		
		//variable for gmail host
		String host ="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
		
		
		//setp 1: to get the session object
		Session session = Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("yourEmail","yourEmailPassword");
			}
			
		});
		
		session.setDebug(true);
		
		//step2: compose the message[text,multi media]
		MimeMessage m=new MimeMessage(session);
		
		//from email 
		try {
			m.setFrom(from);
			
			//adding recipient to 
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//add text to message
			m.setText(message);
			
			//send
			
			//step 3 : send the message using transport class
			Transport.send(m);
			
			System.out.println("Message sent");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
