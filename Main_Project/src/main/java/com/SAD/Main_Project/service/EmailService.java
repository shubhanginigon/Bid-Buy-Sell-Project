package com.SAD.Main_Project.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage emailMsg);
}
