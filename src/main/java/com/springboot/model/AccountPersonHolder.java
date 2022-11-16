package com.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "T_accountpersonrel")
public class AccountPersonHolder {
    @EmbeddedId
    AccountPersonId accountPersonId;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    private Person person;

    public AccountPersonHolder() {
    }

    public AccountPersonHolder(AccountPersonId accountPersonId, Account account, Person person) {
        this.accountPersonId = accountPersonId;
        this.account = account;
        this.person = person;
    }

    public AccountPersonId getAccountPersonId() {
        return accountPersonId;
    }

    public void setAccountPersonId(AccountPersonId accountPersonId) {
        this.accountPersonId = accountPersonId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
