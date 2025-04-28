package com.example.account_service.controller;

import com.example.account_service.dto.AccountResponse;
import com.example.account_service.dto.UserDTO;
import com.example.account_service.entity.Account;
import com.example.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account acc){
        return ResponseEntity.ok(accountService.createAccount(acc));
    }

    @GetMapping
    public ResponseEntity<List<Account>> all() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> byId(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> byUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(accountService.getAccountsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account acc) {
        return ResponseEntity.ok(accountService.updateAccount(id, acc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/with-user/{accountId}")
    public ResponseEntity<AccountResponse> getAccountWithUser(@PathVariable Long accountId) {
        Account account = accountService.getById(accountId);

        // Fetch user info from user-service using Eureka service name
        UserDTO user = restTemplate.getForObject(
                "http://user-service/api/users/" + account.getUserId(),
                UserDTO.class
        );

        AccountResponse response = new AccountResponse(account, user);
        return ResponseEntity.ok(response);
    }
}
