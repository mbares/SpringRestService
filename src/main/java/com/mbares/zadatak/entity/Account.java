package com.mbares.zadatak.entity;

import org.apache.commons.lang.RandomStringUtils;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    private int id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "credit")
    private double credit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public Account() {}

    public Account (User user) {
        this.user = user;
        credit = 0;
        accountNumber = RandomStringUtils.random(9, false, true) + user.getId();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", credit=" + credit +
                ", user=" + user +
                '}';
    }
}
