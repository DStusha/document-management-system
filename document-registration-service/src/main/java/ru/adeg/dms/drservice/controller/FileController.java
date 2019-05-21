package ru.adeg.dms.drservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.adeg.dms.drservice.service.FileStorageService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    FileStorageService fileStorage;

    @PostMapping("/")
    public ResponseEntity uploadMultipartFile(@RequestParam MultipartFile file) {
        try {
            fileStorage.store(file);
        } catch (Exception e) {

        }
        return new ResponseEntity<Map<String, Object>>( new HashMap<String, Object>(), HttpStatus.OK);
    }

}

