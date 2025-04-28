package com.example.account_service.dto;

import com.example.account_service.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private Account account;
    private UserDTO user;
}
