package com.email.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	public EmailService emailService;
	
	@PostMapping("/email/send")
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, Object> request) {
		boolean flag = false;
		try {
		
			if(request!=null)	{
				flag =	emailService.emailSend(request.get("subject").toString(), request.get("message").toString(), request.get("to").toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag ? ResponseEntity.ok("Email Sent Successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent");
	}
	
	

}
