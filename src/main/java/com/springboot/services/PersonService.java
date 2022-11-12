package com.springboot.services;

import com.springboot.model.Person;
import com.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private  PersonRepository personRepository;
    private static Map<Long, Person> personRepo = new HashMap<>();


    public  Person savePerson(Person person) {

      return   personRepository.save(person);
    }

    public  void deletePerson(Person person) {
        personRepository.delete(person);
    }
    public void deleteById(Long id){
        personRepository.deleteById(id);}

    public  void updatePerson(Long id, Person person) {
        personRepo.remove(id);
        person.setId(id);
        personRepo.put(id, person);
    }

    public  Iterable<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public  Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
    public void findByCode(String code){
         personRepository.findByCode(code);
    }
  //  public boolean checkPerson(Person person){
       // person.g
   // }

}



