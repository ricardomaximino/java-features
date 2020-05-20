package com.brasajava.domain;

import java.util.Arrays;

public class Email implements Contact {
    private final String type = "E-Mail";
    private String name;
    private String email;

    public Email() {
    }

    public Email(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // 3 dot on parameters type ☻ = 258 ♥ = 259 > = 2622  < = 2620
    public void test(String... number) {

        if (number.length == 0){
            System.out.println("No Argument was passed");
        }

        if (number.length == 1){
            System.out.println("One Argument was passed");
        }

        if(number.length > 1){
            Arrays.stream(number).forEach(p -> System.out.println("Parameter: " + p));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
