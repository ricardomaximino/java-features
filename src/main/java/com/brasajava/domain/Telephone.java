package com.brasajava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telephone implements Contact {

    private String name;
    private String telephone;

    @Override
    public String getContact() {
        return this.telephone;
    }
}
