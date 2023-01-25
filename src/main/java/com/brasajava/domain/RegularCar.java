package com.brasajava.domain;

public class RegularCar extends Car{
    public RegularCar(CarRadio carRadio, String type) {
        super(carRadio, type);
    }

    public String getCarTypeAndRadioName(){
        return this.getCarType() + " " + this.carRadio.getName();
    }
}
