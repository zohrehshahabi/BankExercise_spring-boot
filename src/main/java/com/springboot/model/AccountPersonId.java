package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountPersonId implements Serializable {
    private static final long serialVersionUID = 5843742737824179130L;
    @Column(name = "ap_acc_id")
    private long accountId;
    @Column(name = "ap_prs_id")
    private long personId;

    public AccountPersonId() {
    }

    public AccountPersonId(long accountId, long personId) {
        this.accountId = accountId;
        this.personId = personId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
