package ru.adeg.dms.drservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.adeg.dms.drservice.entity.DocumentEntity;

public interface DocumentRepository extends MongoRepository<DocumentEntity, String> {
}
