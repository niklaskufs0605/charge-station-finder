package com.niklas.chargestationfinder.Enums;

import lombok.Getter;

@Getter
public enum OtherFilter {
    free_charging("Free-Charging"),
    free_parking("Free-Parking"),
    open_now("Open"),
    exclude_faults("Exclude faults");

    private String name;

    private OtherFilter(String name) {
        this.name = name;
    }
}
