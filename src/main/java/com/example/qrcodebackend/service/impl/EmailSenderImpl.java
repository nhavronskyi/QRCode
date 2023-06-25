package com.example.qrcodebackend.service.impl;

import com.example.qrcodebackend.config.MailProps;
import com.example.qrcodebackend.service.EmailSender;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {
    private final JavaMailSender mailSender;

    @SneakyThrows
    public void sendEmail(String toEmail, String body) {
        body = body.substring(1, body.length() - 1).substring(body.indexOf(","));
        byte[] bytes = Base64.getDecoder().decode(body);
        MimeMessage message = mailSender.createMimeMessage();

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("here is your magic symbol: ");
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.setDataHandler(new DataHandler(new ByteArrayDataSource(bytes, "image/png")));
        attachmentPart.setFileName("image.png");
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("QRCode from MedievalQrCodeTeam");

        mailSender.send(message);
    }
}
