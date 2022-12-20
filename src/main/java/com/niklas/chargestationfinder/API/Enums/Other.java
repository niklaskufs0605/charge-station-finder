package com.niklas.chargestationfinder.API.Enums;

public enum Other {
    free_charging("Free-Charging"),
    free_parking("Free-Parking"),
    open_now("Open"),
    exclude_faults("Exclude faults");

    private String name;

    private Other(String name) {
        this.name = name;
    }
}
