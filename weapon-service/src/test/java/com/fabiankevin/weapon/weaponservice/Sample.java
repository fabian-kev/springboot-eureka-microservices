package com.fabiankevin.weapon.weaponservice;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Sample {


    @Test
    public void sampleDateFormat(){
        System.out.println(Math.random() * 10);
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM.dd.YY")));
    }

}
