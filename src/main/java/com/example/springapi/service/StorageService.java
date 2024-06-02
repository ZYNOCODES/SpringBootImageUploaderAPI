package com.example.springapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class StorageService {
    public String uploadImage(MultipartFile file) throws IOException {
        String folder = "../JAVA-EE-PROJECT/src/main/webapp/images/";
        Path directoryPath = Paths.get(folder);
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String dateTimeString = LocalDateTime.now().format(formatter);

        byte[] bytes = file.getBytes();
        String url = "Image"+dateTimeString+".jpeg";
        Path path = Paths.get(folder+url);
        Files.write(path, bytes);
        return url;
    }
}
