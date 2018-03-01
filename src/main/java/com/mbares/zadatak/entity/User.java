package com.mbares.zadatak.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private int id;

    @NotEmpty
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "username")
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 6, max = 256)
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    @Column(name = "accounts")
    private List<Account> accounts;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public User() {}

    public User(@NotEmpty @NotNull String firstName, @NotEmpty @NotNull String lastName, @NotEmpty @NotNull @Size(min = 3, max = 20) String username, @NotEmpty @NotNull @Size(min = 6, max = 32) String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        enabled = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
