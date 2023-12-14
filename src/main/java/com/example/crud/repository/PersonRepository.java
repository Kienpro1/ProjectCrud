package com.example.crud.repository;

import com.example.crud.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}