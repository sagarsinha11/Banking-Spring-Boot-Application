package com.example.account_service.service;

import com.example.account_service.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account createAccount(Account account);

    List<Account> getAllAccounts();

    List<Account> getAccountsByUserId(Long userId);

    Optional<Account> getAccountById(Long id);

    Account updateAccount(Long id, Account account);

    void deleteAccount(Long id);

    Account getById(Long accountId);
}
