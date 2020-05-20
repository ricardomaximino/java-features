package com.brasajava.domain;

public class Telephone implements Contact {

    private String name;

    public Telephone() {
    }

    public Telephone(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String telephone;

    public String getName() {
        return name;
    }

    public String getContact() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
