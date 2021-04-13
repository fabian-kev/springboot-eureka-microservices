package com.fabiankevin.weapon.weaponservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeaponServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeaponServiceApplication.class, args);
    }

}
