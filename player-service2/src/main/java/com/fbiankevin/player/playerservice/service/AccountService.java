package com.fbiankevin.player.playerservice.service;

import com.fbiankevin.player.playerservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountService {

    @GetMapping("/accounts/{id}")
    Account findOne(@PathVariable("id") Long id);
}
