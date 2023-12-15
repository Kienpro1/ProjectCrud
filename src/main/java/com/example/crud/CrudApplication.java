package com.example.crud;

import com.example.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CrudApplication {
    @Autowired
    private PersonService personService;
    @GetMapping

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

}
