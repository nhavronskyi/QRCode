package com.example.qrcodebackend.controllers;

import com.example.qrcodebackend.service.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("qr")
@RequiredArgsConstructor
public class QRController {
    private final QRCodeGenerator generator;

    @PostMapping
    public byte[] generateQRCode(@RequestBody String str) {
        return generator.getQRCodeImage(str);
    }
}
