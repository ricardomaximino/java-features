package com.brasajava.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularCarTest {

    @Test
    void createARegularCar(){
        String type = "Regular Car";
        CarRadio regularCarRadio = new CarRadio("Regular Car Radio");
        RegularCar regularCar = new RegularCar(regularCarRadio, type);

        assertEquals(regularCarRadio.getName(), regularCar.getRadioName());
        assertEquals(type, regularCar.getCarType());
        assertEquals(type + " " + regularCarRadio.getName(), regularCar.getCarTypeAndRadioName());
    }

}