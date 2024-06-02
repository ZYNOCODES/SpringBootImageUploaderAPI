package com.example.springapi;

import com.example.springapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class SpringApiApplication {

    @Autowired
    private StorageService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String image = "";
        try {
            String path = service.uploadImage(file);
            image = path;
        }catch (Exception err){
            err.printStackTrace();
            System.out.println(err);
        }
        return image;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApiApplication.class, args);
    }
}
