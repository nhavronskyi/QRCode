package com.example.qrcodebackend.controllers;

import com.example.qrcodebackend.service.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mail")
@RequiredArgsConstructor
public class EmailController {
    private final EmailSender sender;

    @PostMapping
    public void sendMessage(@RequestParam String email, @RequestBody String body) {
        sender.sendEmail(email, body);
    }
}
