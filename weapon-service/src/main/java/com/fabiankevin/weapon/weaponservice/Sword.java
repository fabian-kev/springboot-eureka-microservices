package com.fabiankevin.weapon.weaponservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sword extends Weapon {
    private Double weight;

    public Sword(Double attack, String name, Double weight) {
        super(attack, name);
        this.weight = weight;
    }
}
