package com.brasajava.domain;

public abstract class Car {

    protected CarRadio carRadio;
    private final String type;

    public Car(CarRadio carRadio, String type){
        this.carRadio = carRadio;
        this.type = type;
    }

    public String getRadioName(){
        return carRadio.getName();
    }

    public String getCarType(){
        return type;
    }
}
