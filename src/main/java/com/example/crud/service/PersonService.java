package com.example.crud.service;

import com.example.crud.person.Person;
import com.example.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//tạo interface có các phương thức mặc định
@Service
public interface PersonService {
    Page<Person> getAll(Integer pageNo);
    void savePerson(Person person);
    void deletePerson(Long id);

    Optional<Person> findPersonById(Long id);


}
