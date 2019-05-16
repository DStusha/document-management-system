package ru.adeg.dms.saservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adeg.dms.saservice.entity.DocumentTypePermissions;

@Repository
public interface DocumentTypePermissionsRepository extends JpaRepository<DocumentTypePermissions, Long> {}
