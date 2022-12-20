package com.niklas.chargestationfinder.API.Station;

import com.mongodb.lang.Nullable;
import com.niklas.chargestationfinder.API.Enums.Network;
import com.niklas.chargestationfinder.API.Model.Address;
import com.niklas.chargestationfinder.API.Model.ChargePoint;
import com.niklas.chargestationfinder.API.Model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "Stations")
@AllArgsConstructor
public class Station {
    @Id
    @Nullable
    private String id;
    private String name;
    private Address address;
    private ChargePoint chargePoint;
    private Coordinates coordinates;
    private boolean faultReport;
    private Network network;

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address.toString() +
                ", chargePoints=" + chargePoint.toString() +
                ", coordinates=" + coordinates.toString() +
                ", faultReport=" + faultReport +
                ", network=" + network.toString() +
                '}';
    }
}
