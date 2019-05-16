package ru.adeg.dms.saservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adeg.dms.saservice.entity.Directory;

import java.util.Optional;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory,Long> {
    Optional<Directory> findByName(String name);
}
