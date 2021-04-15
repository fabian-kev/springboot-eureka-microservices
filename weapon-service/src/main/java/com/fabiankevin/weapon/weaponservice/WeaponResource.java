package com.fabiankevin.weapon.weaponservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeaponResource {
    private String message;
    private List<Weapon> swords;
}
