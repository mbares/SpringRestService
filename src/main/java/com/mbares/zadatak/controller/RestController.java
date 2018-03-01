package com.mbares.zadatak.controller;

import com.mbares.zadatak.entity.User;
import com.mbares.zadatak.service.AccountManagementService;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/account-management")
public class RestController {

    private AccountManagementService accountManagementService;

    public RestController(AccountManagementService accountManagementService) {
        this.accountManagementService = accountManagementService;
    }

    @GetMapping
    public void createAccount(@RequestParam("username") String username) {
        accountManagementService.createAccount(username);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam("username") String username, @RequestParam("accountNumber") String accountNumber) {
        accountManagementService.deleteAccount(username, accountNumber);
    }

    @PutMapping
    public void addCreddit(@RequestParam("username") String username, @RequestParam("accountNumber") String accountNumber, @RequestParam("credit") double credit) {
        accountManagementService.addCredit(username, accountNumber, credit);
    }

    @PostMapping
    public void sendCredit(@RequestParam("username") String username, @RequestParam("originAccountNumber") String originAccountNumber, @RequestParam("destinationAccountNumber") String destinationAccountNumber, @RequestParam("credit") double credit) {
        accountManagementService.sendCredit(username, originAccountNumber, destinationAccountNumber, credit);
    }
}
