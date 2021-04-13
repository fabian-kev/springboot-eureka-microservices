package com.fabiankevin.weapon.weaponservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Weapon {
    private Double attack;
    private String name;
}
