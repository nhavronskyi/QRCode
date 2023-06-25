package com.example.qrcodebackend.service.impl;

import java.io.ByteArrayOutputStream;

import com.example.qrcodebackend.service.QRCodeGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class QRCodeGeneratorImpl implements QRCodeGenerator {
    @SneakyThrows
    public byte[] getQRCodeImage(String text) {
        BitMatrix bitMatrix = new QRCodeWriter()
                .encode(text, BarcodeFormat.QR_CODE, 500, 500);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }
}
