package com.niklas.chargestationfinder.API.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {
    private String street;
    private int postcode;
    private String country;
    private String city;
}
