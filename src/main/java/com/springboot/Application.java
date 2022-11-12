package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaAuditing // Enabling JPA Auditing
public class Application  {

   /* @Autowired
    private PersonService personService;*/

/*    @Override
    public void run(String... args) throws Exception {

        // Create an person
        Person person1= new Person();
        person1.setName("ziba");
        person1.setCode("12");
        person1.setCustomerNumber("12345");
//create accountType
        AccountType accountType=new AccountType();
        accountType.setTitle("best Account");
        // Create account1
        Account account1=new Account();
        account1.setAccountNumber("1345");
        account1.setOpen(true);
        account1.setAccountType(accountType);
       // account1.setPersons(person1);



        //create accountType2
        AccountType accountType1=new AccountType();
        accountType1.setTitle("average account");

        //create account2
        Account account2=new Account();
        account2.setAccountNumber("1346");
        account2.setOpen(true);
        account2.setAccountType(accountType1);

        //person can have two accounts,and account refrences in the person
        person1.getAccounts().add(account1);
        person1.getAccounts().add(account2);

        //add person reference in the account
        account1.getPersons().add(person1);
        account2.getPersons().add(person1);

        //save service
        personService.savePerson(person1);

    }*/

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
