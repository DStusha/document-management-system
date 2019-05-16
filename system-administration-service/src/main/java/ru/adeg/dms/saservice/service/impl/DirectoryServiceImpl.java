package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.Directory;
import ru.adeg.dms.saservice.repository.DirectoryRepository;
import ru.adeg.dms.saservice.service.DirectoryService;

import java.util.List;
import java.util.Optional;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    private DirectoryRepository directoryRepository;

    public Directory addDirectory(Directory directory) {
        return directoryRepository.saveAndFlush(directory);
    }

    public void delete(long id) {
        directoryRepository.deleteById(id);
    }

    public List<Directory> getAll() {
        return directoryRepository.findAll();
    }

    public Optional<Directory> getDirectoryByName(String name) {
        return directoryRepository.findByName(name);
    }

    public Optional<Directory> getDirectoryById(Long id) {
        return directoryRepository.findById(id);
    }

}
