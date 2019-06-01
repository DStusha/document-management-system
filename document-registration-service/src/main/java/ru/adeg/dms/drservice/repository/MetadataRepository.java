package ru.adeg.dms.drservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.adeg.dms.drservice.entity.Metadata;

public interface MetadataRepository extends MongoRepository<Metadata, String> {}
