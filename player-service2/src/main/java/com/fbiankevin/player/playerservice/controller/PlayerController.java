package com.fbiankevin.player.playerservice.controller;

import com.fbiankevin.player.playerservice.model.Account;
import com.fbiankevin.player.playerservice.model.Player;
import com.fbiankevin.player.playerservice.model.resource.PlayerResource;
import com.fbiankevin.player.playerservice.repository.PlayerRepository;
import com.fbiankevin.player.playerservice.service.AccountService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("players")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final AccountService accountService;
    @GetMapping
    List<Player> all(){
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    PlayerResource findOne(@PathVariable Long id){
        log.debug("get one player by "+id);
        return playerRepository.findById(id)
                .map(player -> PlayerResource.builder()
                        .player(player)
                        .account(findAccountById(player.getAccountId()))
                        .build())
                .orElseThrow(() -> new RuntimeException("Unable to find player with id "+id));
    }

    @PostMapping
    PlayerResource create(@Valid @RequestBody Player player){
        Account account = findAccountById(player.getAccountId());
        player = this.playerRepository.save(player);

        return PlayerResource.builder()
                .account(account)
                .player(player)
                .build();
    }


    private Account findAccountById(Long id){
        try {
            return accountService.findOne(id);
        } catch (FeignException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
}
