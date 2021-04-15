package com.fabiankevin.weapon.weaponservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/swords")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponRepository weaponRepository;
    @Value("${message: Unable to fetch message from config server}")
    private String message;

    @GetMapping
    public WeaponResource getSwords(){
        WeaponResource weaponResource = WeaponResource.builder()
                .message(message)
                .swords(weaponRepository.findAll()
                        .stream().map(entity -> {
                            return Weapon.builder()
                                    .attack(entity.getAttack())
                                    .name(entity.getName())
                                    .build();
                        }).collect(Collectors.toList()))
                .build();
        return weaponResource;
    }

    @GetMapping("/greetings")
    public String greetings(){
        return message;
    }



    @PostMapping
    String create(@RequestBody Weapon weapon){
        WeaponEntity entity = new WeaponEntity();
        entity.setAttack(weapon.getAttack());
        entity.setName(weapon.getName());
        entity.setType("Sword");
        weaponRepository.save(entity);

        return "You've successfully created a sword!";
    }

}
