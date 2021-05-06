package com.fbiankevin.account.accountservice.controller;

import com.fbiankevin.account.accountservice.models.Account;
import com.fbiankevin.account.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;


    @PostMapping
    Account create(@RequestBody Account account){
        return accountRepository.save(account);
    }

    @GetMapping
    List<Account> all(){
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    Account getOne(@PathVariable Long id){
        return accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Unable to find account with id %s", id)));
    }

}
