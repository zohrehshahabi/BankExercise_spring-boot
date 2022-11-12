package com.springboot.controller;

import com.springboot.services.PersonService;
import com.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @PostMapping
    Person addPerson(@RequestBody Person person) {
        try {
            return personService.savePerson(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping
    void updatePerson(@RequestBody Person person) {
        try {
            personService.savePerson(
                    person
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Long id) {
        try {
            personService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



