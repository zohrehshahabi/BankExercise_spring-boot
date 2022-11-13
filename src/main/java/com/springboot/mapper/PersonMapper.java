package com.springboot.mapper;

import com.springboot.dto.AccountDto;
import com.springboot.dto.AccountRequestDto;
import com.springboot.dto.PersonDto;
import com.springboot.dto.PersonRequestDto;
import com.springboot.model.Account;
import com.springboot.model.Person;

import java.util.List;

public class PersonMapper {
    public Person toPerson(PersonRequestDto personRequestDto) {
        Person person=new Person();
        person.setCode(personRequestDto.getCode());
        person.setCustomerNumber("");
        return person;
    }

    public List<PersonDto> toPersonDtos(List<Person> persons) {
        return null;
    }
}
