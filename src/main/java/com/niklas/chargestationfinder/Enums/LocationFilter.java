package com.niklas.chargestationfinder.Enums;

import lombok.Getter;

@Getter
public enum LocationFilter {
    HotelLodging("Hotel/Lodging"),
    Dining("Dining"),
    Restroom("Restroom"),
    Parking("Parking"),
    WiFi("WiFi"),
    Shopping("Shopping"),
    Grocery("Grocery");


    private String locationName;
    private LocationFilter(String locationName){
        this.locationName = locationName;
    }
}
