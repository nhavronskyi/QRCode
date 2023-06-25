package com.example.qrcodebackend.service;

public interface QRCodeGenerator {
    byte[] getQRCodeImage(String text);
}
