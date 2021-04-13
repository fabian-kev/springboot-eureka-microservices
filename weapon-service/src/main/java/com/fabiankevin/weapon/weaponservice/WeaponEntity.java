package com.fabiankevin.weapon.weaponservice;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "WP_WEAPON")
@Entity
public class WeaponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Double attack;
}
