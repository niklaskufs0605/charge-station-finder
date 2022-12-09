package com.niklas.chargestationfinder.Enums;

import lombok.Getter;

@Getter
public enum PlugFilter {
    TeslaFast("Tesla (Fast)"),
    CCS("CCS/SAE"),
    CHAdeMO("CHAdeMO"),
    J1772("J-1772"),
    Tesla("Tesla"),
    TeslaRoadster("Tesla (Roadstar)"),
    Type2("Type 2"),
    Type3("Type 3"),
    ThreePhase("Three Phase"),
    WallEuro("Wall (Euro)"),
    Type3A("Type 3A");



    ;


    String name;
    private PlugFilter(String name) {
        this.name = name;
    }
}
