package com.niklas.chargestationfinder.API.Model;

import com.niklas.chargestationfinder.API.Enums.Plug;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ChargePoint {
    private int minPower;
    private Plug plug;
    //private List<Reservation> reservation;
    private boolean[] reservedHours = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    public ChargePoint(int minPower, Plug plug) {
        this.minPower = minPower;
        this.plug = plug;
    }

    //Method to reserve a Station
    public void reserve(int from, int to){
        for(int i = from;i<=to;i++){
            reservedHours[i] = true;
        }
    }

}
