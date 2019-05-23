package ru.adeg.dms.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.adeg.dms.client.model.Directory;

@RestController
public class DirectoryController {

    @GetMapping(value = "/directories")
    public ResponseEntity<Directory> getDirectories(@RequestParam String name) {
        return ResponseEntity.ok().body(new Directory(name));
    }
}
