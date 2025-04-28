package com.example.account_service.service;

import com.example.account_service.entity.Account;
import com.example.account_service.exception.ResourceNotFoundException;
import com.example.account_service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {

        return Optional.ofNullable(accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with id:" + id)));
    }

    @Override
    public Account updateAccount(Long id, Account updatedAccount) {
        return accountRepository.findById(id)
                .map(acc -> {
                    acc.setAccountNumber(updatedAccount.getAccountNumber());
                    acc.setBalance(updatedAccount.getBalance());
                    return accountRepository.save(acc);
                }).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);

    }

    @Override
    public Account getById(Long accountId) {
        return null;
    }
}
