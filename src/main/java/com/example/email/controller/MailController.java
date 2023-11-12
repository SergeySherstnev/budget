package com.example.email.controller;

import com.example.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public ResponseEntity<String> welcome() {
        System.out.println("Sending mail...");
        sendEmail();
        System.out.println("Done");
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    private void sendEmail() {
        String to = "sergei.sherstnev@telekom.com";
        String subject = "Test by SpringBoot";
        String message = "Hello! \n\n Welcome to Spring Boot";

        emailService.sendSimpleMessage(to, subject, message);
    }
}
