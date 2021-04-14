package com.fabiankevin.weapon.weaponservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/swords")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponRepository weaponRepository;
    @Value("${message: Unable to fetch message from config server}")
    private String message;

    @GetMapping
    public WeaponResource getSwords(){
        return WeaponResource.builder()
                .swords(Arrays.asList(
                        new Sword(1000.0, "Katana", 50.0),
                        new Sword(5000.0, "Muramasa", 200.0),
                        new Sword(100.0, "Blade", 20.0),
                        new Sword(10000.0, "Divine Rapier", 0.0)
                ))
                .message(message)
                .build();
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
