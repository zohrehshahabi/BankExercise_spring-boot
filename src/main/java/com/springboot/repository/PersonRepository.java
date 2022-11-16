package com.springboot.repository;

import com.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
    Person findByCode(String code);

    Optional<Person> findByName(String name);
    //Person findByCustomerNo(Integer customerNo);
    //void updatePerson(Long id, Person person);
    //public abstract void updateProduct(Long id,Person  person);

}
