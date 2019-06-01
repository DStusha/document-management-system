package ru.adeg.dms.drservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.adeg.dms.drservice.service.MetadataService;

@SpringBootApplication
public class Application{

    @Autowired
    MetadataService service;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
