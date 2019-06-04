package ru.adeg.dms.drservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.adeg.dms.drservice.entity.DocumentMetadata;

public interface DocumentMetadataRepository extends MongoRepository<DocumentMetadata, String> {}
