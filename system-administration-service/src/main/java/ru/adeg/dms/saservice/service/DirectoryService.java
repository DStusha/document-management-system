package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.Directory;

import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    Directory addDirectory(Directory directory);
    void delete(long id);
    List<Directory> getAll();
    Optional<Directory> getDirectoryByName(String name);
    Optional<Directory> getDirectoryById(Long id);
}
