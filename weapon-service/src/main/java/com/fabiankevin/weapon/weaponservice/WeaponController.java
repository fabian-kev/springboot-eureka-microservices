package com.fabiankevin.weapon.weaponservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/swords")
public class WeaponController {


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

}
