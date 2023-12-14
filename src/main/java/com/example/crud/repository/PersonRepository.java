package com.example.crud.repository;

import com.example.crud.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//tạo interface kế thừa từ jqa repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE CONCAT(p.name, p.age, p.email, p.phone) LIKE %?1%")
    public List<Person> search(String value);


}