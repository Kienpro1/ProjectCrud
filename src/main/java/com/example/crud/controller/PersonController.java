package com.example.crud.controller;

import com.example.crud.person.Person;
import com.example.crud.service.PersonService;
import com.example.crud.service.PersonServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Person> persons = personService.getAll();

        model.addAttribute("persons", persons);

        return "index";
    }

    @RequestMapping(value = "add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPerson(@RequestParam("id") Long personId, Model model) {
        Optional<Person> personEdit = personService.findPersonById(personId);
        personEdit.ifPresent(person -> model.addAttribute("person", person));
        return "editPerson";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Person person) {
        personService.savePerson(person);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePerson(@RequestParam("id") Long personId, Model model) {
        personService.deletePerson(personId);
        return "redirect:/";
    }

}
