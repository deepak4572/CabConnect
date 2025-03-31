package com.codingshuttle.project.uber.uberApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingshuttle.project.uber.uberApp.services.EmailSenderService;

@SpringBootTest
class UberAppApplicationTests {
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail("fewexa3220@nokdot.com", "This is the Testing Email", "Body of my email");
	}
	
	@Test
	void sendEmailMultiple() {
		String emails[] = {
				"fewexa3220@nokdot.com",
				"xedivoj799@oronny.com"
		};
		emailSenderService.sendEmail(emails, "Hello from Uber application demo", "This is a good boy, keep coding!");
	}

}
