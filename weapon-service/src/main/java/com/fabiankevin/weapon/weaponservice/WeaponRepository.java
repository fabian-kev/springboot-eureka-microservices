package com.fabiankevin.weapon.weaponservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<WeaponEntity, Long> {
}
