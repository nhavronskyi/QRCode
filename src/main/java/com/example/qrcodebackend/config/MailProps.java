package com.example.qrcodebackend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mail")
@Component
@Getter
@Setter
public class MailProps {
    private String username;
    private String password;
}
