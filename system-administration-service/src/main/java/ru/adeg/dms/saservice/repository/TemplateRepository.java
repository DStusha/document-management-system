package ru.adeg.dms.saservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.adeg.dms.saservice.entity.Template;

import java.util.Optional;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Long> {
    Optional<Template> findByName(String name);
}
