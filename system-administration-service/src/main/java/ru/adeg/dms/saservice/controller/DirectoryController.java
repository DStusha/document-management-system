package ru.adeg.dms.saservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adeg.dms.saservice.entity.Directory;
import ru.adeg.dms.saservice.service.DirectoryService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directories")
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @GetMapping
    public ResponseEntity<List<Directory>> allDirectories() {
        List<Directory> directories = directoryService.getAll();
        return ResponseEntity.ok().body(directories);
    }

    @GetMapping(value = "/{directoryId}")
    public ResponseEntity<Directory> getDirectory(@PathVariable("directoryId") Long directoryId)
            throws EntityNotFoundException {
        Optional<Directory> Directory = directoryService.getDirectoryById(directoryId);
        if (!Directory.isPresent())
            throw new EntityNotFoundException("id-" + directoryId);
        return ResponseEntity.ok().body(Directory.get());
    }

    @PostMapping
    public ResponseEntity<Directory> createDirectory(@RequestBody @Valid Directory Directory) {
        Directory p = directoryService.addDirectory(Directory);
        return ResponseEntity.status(201).body(p);
    }

    @PutMapping(value = "/{directoryId}")
    public ResponseEntity<Directory> updateDirectory(@RequestBody @Valid Directory Directory,
                                                     @PathVariable("directoryId") Long directoryId) throws EntityNotFoundException {
        Optional<Directory> p = directoryService.getDirectoryById(directoryId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + directoryId);
        return ResponseEntity.ok().body(directoryService.addDirectory(Directory));
    }

    @DeleteMapping(value = "/{directoryId}")
    public ResponseEntity<Directory> deleteDirectory(@PathVariable("directoryId") Long directoryId)
            throws EntityNotFoundException {
        Optional<Directory> p = directoryService.getDirectoryById(directoryId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + directoryId);
        directoryService.getDirectoryById(directoryId);
        return ResponseEntity.ok().body(p.get());
    }

}
