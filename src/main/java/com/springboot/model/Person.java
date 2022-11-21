package com.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name =  "person")
@Table(name = "T_Person")
public class Person {
    @NotNull
    @Id
    @Column(name = "prs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "prs_name")
    private String name;
    @NotNull
    @Size(max=11)
    @Column(name = "prs_code", unique = true)
    private String code;

    @Column(name = "prs_customerNum")
    private String customerNumber;

    /* @ManyToMany(targetEntity = Person.class,cascade = CascadeType.ALL)
     @JoinTable(name="T_accountholder",joinColumns = @JoinColumn(name="prs_id")
     ,inverseJoinColumns = @JoinColumn(name="acc_id")
    )
     private List<Account> accounts;*/
    @OneToMany(mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<AccountPersonHolder> accountPersonHolderList = new ArrayList<>();

    public Person( String name, String code, String customerNumber) {
        this.name = name;
        this.code = code;
        this.customerNumber = customerNumber;
    }

    public Person() {
    }

    public List<AccountPersonHolder> getAccountPersonList() {
        return accountPersonHolderList;
    }

    public void setAccountPersonList(List<AccountPersonHolder> accountPersonHolderList) {
        this.accountPersonHolderList = accountPersonHolderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(code, person.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
