package com.brasajava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Contact {
    private final String type = "E-Mail";
    private String name;
    private String email;

    @Override
    public String getContact() {
        return this.email;
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

}
