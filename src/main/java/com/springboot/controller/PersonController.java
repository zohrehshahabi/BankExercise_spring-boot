package com.springboot.controller;

import com.springboot.dto.PersonDto;
import com.springboot.dto.PersonRequestDto;
import com.springboot.mapper.PersonMapper;
import com.springboot.model.Account;
import com.springboot.services.PersonService;
import com.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService personService;
  /*  private PersonMapper personMapper;
    @PostMapping
        public ResponseEntity<Void> addPerson (@RequestBody PersonRequestDto personRequestDto) {
          Person person = personMapper.toPerson(personRequestDto);
          personService.savePerson(person);
          return ResponseEntity.ok().build();
       }
       @GetMapping
       public ResponseEntity<List<PersonDto>> getAllPersons() {
         return ResponseEntity.ok (personMapper.toPersonDtos((List<Person>) personService.getAllPerson()));
      }*/

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
    /*@PutMapping
    public ResponseEntity<Void> updatePerson (@RequestBody PersonRequestDto personRequestDto) {
        Person person = personMapper.toPerson(personRequestDto);
        personService.savePerson(person);
        return ResponseEntity.ok().build();
    }*/

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
    @GetMapping("/{id}")
    public void findById(@PathVariable(name = "id") Long id) {
        try {
            personService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



