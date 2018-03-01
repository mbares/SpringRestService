package com.mbares.zadatak.service;

import com.mbares.zadatak.entity.Account;
import com.mbares.zadatak.entity.User;
import com.mbares.zadatak.repository.AccountRepository;
import com.mbares.zadatak.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountManagementService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountManagementService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void createAccount(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User with username: " + username + " doesn't exist");
            return;
        }
        Account account = new Account(user);
        accountRepository.save(account);
        System.out.println("Create account: " + account);
    }

    public void deleteAccount(String username,  String accountNumber) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User with username: " + username + " doesn't exist");
            return;
        }
        Account account = accountRepository.findAccountByUserAndAccountNumber(user, accountNumber);
        if (account != null) {
            accountRepository.delete(account);
            System.out.println("Delete account: " + account);
        } else {
            System.out.println("Delete account failed, user: " + user + " doesn't own an account with account number: " + accountNumber);
        }
    }

    public void addCredit(String username, String accountNumber, double credit) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User with username: " + username + " doesn't exist");
            return;
        }
        Account account = accountRepository.findAccountByUserAndAccountNumber(user, accountNumber);
        if (account != null) {
            account.setCredit(account.getCredit() + credit);
            accountRepository.save(account);
            System.out.println("User: " + user + " added " + credit + " to his account: " + account);
        } else {
            System.out.println("Add credit failed, user: " + user + " doesn't own an account with account number: " + accountNumber);
        }
    }

    public void sendCredit(String username, String originAccountNumber, String destinatonAccountNumber, double credit) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User with username: " + username + " doesn't exist");
            return;
        }
        Account originAccount = accountRepository.findAccountByUserAndAccountNumber(user, originAccountNumber);
        Account destinationAccount = accountRepository.findAccountByAccountNumber(destinatonAccountNumber);
        if (originAccount != null) {
            if (destinationAccount != null) {
                if (credit <= originAccount.getCredit()) {
                    originAccount.setCredit(originAccount.getCredit() - credit);
                    destinationAccount.setCredit(destinationAccount.getCredit() + credit);
                    accountRepository.save(originAccount);
                    accountRepository.save(destinationAccount);
                    System.out.println("User: " + user + " sent " + credit + " from account: " + originAccount + " to account: " + destinationAccount);
                } else {
                    System.out.println("Send credit failed, not enough credit on origin account");
                }
            } else {
                System.out.println("Send credit failed, destination account doesn't exist");
            }
        } else {
            System.out.println("Send credit failed, user: " + user + " doesn't own an account with account number: " + originAccountNumber);
        }
    }
}
