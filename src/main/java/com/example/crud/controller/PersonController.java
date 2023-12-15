package com.example.crud.controller;

import com.example.crud.person.Person;
import com.example.crud.repository.PersonRepository;
import com.example.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {
    //Dùng lại peronService từ bên class PersonService
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;
    //Map đến / cho trang index
    @RequestMapping("/")
    public String index(Model model,@RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo) {
        //tạo 1 list chứa các đối tượng person bằng thuộc tính getAll() của class crudRepository kế thừa
        Page<Person> persons = personService.getAll(pageNo);
        //thêm thuộc tính vào đối tượng model với key là persons và value là persons
        model.addAttribute("persons", persons);
        model.addAttribute("totalPage", persons.getTotalPages());
        model.addAttribute("currentPage",pageNo);
        //trả về index.html
        return "index";
    }


    @RequestMapping("/search")
    public String search(@RequestParam("value") String value,
                         Model model
                         ) {

        //tạo 1 list chứa các đối tượng person bằng thuộc tính getAll() của class crudRepository kế thừa
        List<Person> persons =
                personRepository.search(value);
        //thêm thuộc tính vào đối tượng model với key là persons và value là persons
        model.addAttribute("persons",persons);
//trả về index.html
        return "index";
    }

    //mapping cho add
    @RequestMapping(value = "add")
    public String addPerson(Model model) {
        //thêm thuộc tính vào đối tượng model với key là persons và value là new Person
        model.addAttribute("person", new Person());
        return "addPerson";
    }
//mapping edit và get thông tin từ button edit ở index.html
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editPerson(@RequestParam("id") Long personId, Model model) {
        //tạo optional để luư đối tượng personEdit
        Optional<Person> personEdit = personService.findPersonById(personId);
        //kiếm tra nếu tồn tại thì thực hiện biểu thức lambda xong return về biến person bằng ifPresent của optional
        personEdit.ifPresent(person -> model.addAttribute("person", person));
        //trả ve form editPerson
        return "editPerson";
    }
    //Mapping với đường dẫn save và button save ở index,html phuương thức post
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Person person) {
        //Lưu person vào personService
        personService.savePerson(person);
        //trả về trang chủ
        return "redirect:/";
    }
    //Mapping với button delete phương thức get
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deletePerson(
            //requestparam lấy id bên form index gán vào personId tạo object model để addAttribute
            @RequestParam("id") Long personId, Model model) {
        //thực hiện phương thức xóa trong personService
        personService.deletePerson(personId);
        //trả về trang chủ khi thực hiên xong
        return "redirect:/";
    }

}
