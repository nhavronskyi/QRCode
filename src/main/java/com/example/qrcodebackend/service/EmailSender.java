package com.example.qrcodebackend.service;

public interface EmailSender {
    void sendEmail(String toEmail, String body);
}
