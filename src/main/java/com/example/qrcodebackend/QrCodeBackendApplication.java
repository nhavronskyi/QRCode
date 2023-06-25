package com.example.qrcodebackend;

import com.example.qrcodebackend.service.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ConfigurationPropertiesScan
public class QrCodeBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(QrCodeBackendApplication.class, args);
    }
}
