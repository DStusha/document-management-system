package ru.adeg.dms.saservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.adeg.dms.saservice.entity.*;
import ru.adeg.dms.saservice.repository.*;


@SpringBootApplication
public class Application {

    @Autowired
    private DocumentTypeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) {
//        DocumentType att = repository.findById(6L).get();
//        att.setName("ssssssssss");
//        repository.saveAndFlush(att);
//    }

}
