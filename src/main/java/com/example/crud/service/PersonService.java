package com.example.crud.service;

import com.example.crud.person.Person;
import com.example.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {
    List<Person> getAll();
    void savePerson(Person person);

    void deletePerson(Long id);

    Optional<Person> findPersonById(Long id);
}