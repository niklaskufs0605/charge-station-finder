package com.niklas.chargestationfinder.API.Model;

import com.niklas.chargestationfinder.API.Enums.Plug;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChargePoint {
    private int minPower;
    private Plug plug;
    private Reservation reservation;
}
